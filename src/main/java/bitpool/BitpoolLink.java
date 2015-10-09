package bitpool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.dsa.iot.dslink.node.Node;
import org.dsa.iot.dslink.node.Permission;
import org.dsa.iot.dslink.node.actions.Action;
import org.dsa.iot.dslink.node.actions.ActionResult;
import org.dsa.iot.dslink.node.actions.EditorType;
import org.dsa.iot.dslink.node.actions.Parameter;
import org.dsa.iot.dslink.node.value.Value;
import org.dsa.iot.dslink.node.value.ValueType;
import org.dsa.iot.dslink.util.Objects;
import org.dsa.iot.dslink.util.StringUtils;
import org.dsa.iot.dslink.util.handler.Handler;

public class BitpoolLink {
//	private final static Logger LOGGER;
//	static {
//        LOGGER = LoggerFactory.getLogger(BitpoolLink.class);
//    }
	
	Node node;
	final Map<Node, ScheduledFuture<?>> futures = new ConcurrentHashMap<Node, ScheduledFuture<?>>();
	final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

	private BitpoolLink(Node node) {
		this.node = node;
	}
	
	public static void start(Node parent) {
		final BitpoolLink link = new BitpoolLink(parent);
		link.init();
	}
	
	private void init() {
		restoreLastSession();
		
		Action act = new Action(Permission.READ, new LoginHandler());
		act.addParameter(new Parameter("Email", ValueType.STRING).setPlaceHolder("name@example.com"));
		Parameter param = new Parameter("Password", ValueType.STRING);
		param.setEditorType(EditorType.PASSWORD);
		act.addParameter(param);
		act.addParameter(new Parameter("Organisation", ValueType.STRING).setPlaceHolder("Bitpool Demonstration"));
		act.addParameter(new Parameter("Place", ValueType.STRING).setPlaceHolder("office"));
		act.addParameter(new Parameter("Polling interval", ValueType.NUMBER, new Value(5)));
		node.createChild("add connection").setAction(act).build().setSerializable(false);
		
	}
	
	private void restoreLastSession() {
		if (node.getChildren() == null) return;
		for (Node child: node.getChildren().values()) {
			Value email = child.getAttribute("Email");
			Value org = child.getAttribute("Organisation");
			Value place = child.getAttribute("Place");
			Value interval = child.getAttribute("Polling interval");
			if (email!=null && org!=null && place!=null && interval!=null) {
				child.clearChildren();
				BitpoolConn conn = new BitpoolConn(getMe(), child);
				conn.init();
			} else if (!child.getName().equals("defs") && child.getAction() == null) {
				node.removeChild(child);
			}
		}
		
	}

	private class LoginHandler implements Handler<ActionResult> {
		public void handle(ActionResult event) {
			String email = event.getParameter("Email", ValueType.STRING).getString();
			String pass = event.getParameter("Password", ValueType.STRING).getString();
			String org = event.getParameter("Organisation", ValueType.STRING).getString();
			String place = event.getParameter("Place", ValueType.STRING).getString();
			double interval = event.getParameter("Polling interval", ValueType.NUMBER).getNumber().doubleValue();
			
			String name = StringUtils.filterBannedChars(email);
			
			Node child = node.createChild(name).build();
			child.setAttribute("Email", new Value(email));
			//child.setAttribute("Password", new Value(pass));
			child.setAttribute("Organisation", new Value(org));
			child.setAttribute("Place", new Value(place));
			child.setAttribute("Polling interval", new Value(interval));
			
			BitpoolConn conn = new BitpoolConn(getMe(), child);
			conn.login(email, pass, org, place);
			conn.init();
		}
	}
	
	void setupStream(final BitpoolStream bs) {
		bs.node.getListener().setOnSubscribeHandler(new Handler<Node>() {
			public void handle(final Node event) {
				if (futures.containsKey(event)) return;
				long interval = (long) (1000 * bs.station.pool.conn.node.getAttribute("Polling interval").getNumber().doubleValue());
				ScheduledThreadPoolExecutor stpe = Objects.getDaemonThreadPool();
		        ScheduledFuture<?> fut = stpe.scheduleWithFixedDelay(new Runnable() {
		            @Override
		            public void run() {
		            	bs.poll();
		            }
		        }, 0, interval, TimeUnit.MILLISECONDS);
		        futures.put(event, fut);
			}
		});
		bs.node.getListener().setOnUnsubscribeHandler(new Handler<Node>() {
			public void handle(final Node event) {
				ScheduledFuture<?> fut = futures.remove(event);
		        if (fut != null) {
		            fut.cancel(false);
		        }
			}
		});
	}
	
	String safeToString(Date date) {
		return (date == null) ? null : dateFormat.format(date);
	}
	
	BitpoolLink getMe() {
		return this;
	}

}
