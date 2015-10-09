package bitpool;

import io.swagger.client.ApiException;
import io.swagger.client.model.BitPoolServerModelBitPoolEntity;
import io.swagger.client.model.BitPoolServerModelBitStationEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dsa.iot.dslink.node.Node;
import org.dsa.iot.dslink.node.Permission;
import org.dsa.iot.dslink.node.actions.Action;
import org.dsa.iot.dslink.node.actions.ActionResult;
import org.dsa.iot.dslink.node.actions.Parameter;
import org.dsa.iot.dslink.node.value.Value;
import org.dsa.iot.dslink.node.value.ValueType;
import org.dsa.iot.dslink.util.handler.Handler;

public class BitpoolPool {
	
	Node node;
	BitpoolConn conn;

	public BitpoolPool(BitpoolConn conn, Node node) {
		this.conn = conn;
		this.node = node;
	}
	
	void init() {
		
		loadStations();
		
		Action act = new Action(Permission.READ, new DeleteHandler());
		node.createChild("delete").setAction(act).build().setSerializable(false);
		
		makeUpdateTZAction();
		
		act = new Action(Permission.READ, new CreateStationHandler());
		act.addParameter(new Parameter("Station name", ValueType.STRING));
		node.createChild("create station").setAction(act).build().setSerializable(false);
		
	}
	
	private void makeUpdateTZAction() {
		Action act = new Action(Permission.READ, new UpdateTZHandler());
		if (conn.timezones == null) return;
		Set<String> enums = new HashSet<String>(conn.timezones.values());
		String defaultTz = node.getAttribute("Time zone").getString();
		act.addParameter(new Parameter("Time zone", ValueType.makeEnum(enums), new Value(defaultTz)));
		Node anode = node.getChild("update time zone");
		if (anode == null) node.createChild("update time zone").setAction(act).build().setSerializable(false);
		else anode.setAction(act);
	}
	
	private class DeleteHandler implements Handler<ActionResult> {
		public void handle(ActionResult event) {
			try {
				conn.poolsApi.poolsDeletePool(node.getAttribute("Pool key").getString());
			} catch (ApiException e) {
				// TODO Auto-generated catch block
			}
			remove();
		}
	}
	
	private void remove() {
		node.clearChildren();
		node.getParent().removeChild(node);
	}
	
	private class UpdateTZHandler implements Handler<ActionResult> {
		public void handle(ActionResult event) {
			String tz = event.getParameter("Time zone", ValueType.STRING).getString();
			//String tz = conn.timezones.get(tzKey);
			BitPoolServerModelBitPoolEntity pool = null;
			try {
				conn.poolsApi.poolsSetPoolTimezone(node.getAttribute("Pool key").getString(), tz);
				pool = conn.poolsApi.poolsGetPool(node.getAttribute("Pool key").getString());
			} catch (ApiException e) {
				// TODO Auto-generated catch block
				return;
			}
			if (pool != null) {
				node.setAttribute("Pool key", new Value(pool.getPoolKey()));
				node.setAttribute("Registration date", new Value(conn.link.safeToString(pool.getRegistrationDate())));
				node.setAttribute("Public", new Value(pool.getPublic()));
				node.setAttribute("Virtual", new Value(pool.getVirtual()));
				node.setAttribute("Owner", new Value(pool.getOwner()));
				node.setAttribute("Access mode", new Value(pool.getAccessMode().toString()));
				node.setAttribute("Utc offset", new Value(pool.getUtcOffset()));
				node.setAttribute("Time zone", new Value(pool.getTimeZone()));
				init();
			}
			
		}
	}
	
	private class CreateStationHandler implements Handler<ActionResult> {
		public void handle(ActionResult event) {
			String name = event.getParameter("Station name", ValueType.STRING).getString();
			BitPoolServerModelBitStationEntity station;
			try {
				station = conn.poolsApi.poolsRegisterStation(node.getAttribute("Pool key").getString(), name);
			} catch (ApiException e) {
				// TODO Auto-generated catch block
				return;
			}
			if (station == null) return;
			
			Node child = node.createChild(station.getStationName()).build();
			
			BitpoolStation bs = makeStationObj(station, child);
			bs.init();
		}
	}
	
	private void loadStations() {
		try {
			List<BitPoolServerModelBitStationEntity> stations = conn.poolsApi.poolsGetStations(node.getAttribute("Pool key").getString());
			for (BitPoolServerModelBitStationEntity station: stations) {
				if (node.getChild(station.getStationName()) == null) {
					Node child = node.createChild(station.getStationName()).build();
					final BitpoolStation bs = makeStationObj(station, child);
					bs.init();
	//				child.getListener().setOnListHandler(new Handler<Node>() {
	//					private boolean loaded = false;
	//					public void handle(Node event) {
	//						if (!loaded) bs.init();
	//						loaded = true;
	//					}
	//				});
				}
			}
		} catch (ApiException e) {
			// TODO Auto-generated catch block
		}
	}

	private BitpoolStation makeStationObj(BitPoolServerModelBitStationEntity station, Node child) {
		child.setAttribute("Pool key", new Value(station.getPoolKey()));
		child.setAttribute("Station id", new Value(station.getStationID()));
		child.setAttribute("Registration date", new Value(conn.link.safeToString(station.getRegistrationDate())));
		
		return new BitpoolStation(getMe(), child);
	}

	private BitpoolPool getMe() {
		return this;
	}

}
