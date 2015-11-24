package bitpool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.AuthenticationApi;
import io.swagger.client.api.PoolsApi;
import io.swagger.client.api.TimezonesApi;
import io.swagger.client.model.BitPoolInfrastructureDTOAUTHLogin2;
import io.swagger.client.model.BitPoolInfrastructureDTOBPRegisterPool;
import io.swagger.client.model.BitPoolInfrastructureDTOCreateAuthKeyDto;
import io.swagger.client.model.BitPoolInfrastructureDTOCreateAuthKeyDto.KeyTypeEnum;
import io.swagger.client.model.BitPoolInfrastructureDTOTimeZoneDto;
import io.swagger.client.model.BitPoolServerModelBitPoolEntity;

import org.dsa.iot.dslink.node.Node;
import org.dsa.iot.dslink.node.Permission;
import org.dsa.iot.dslink.node.actions.Action;
import org.dsa.iot.dslink.node.actions.ActionResult;
import org.dsa.iot.dslink.node.actions.EditorType;
import org.dsa.iot.dslink.node.actions.Parameter;
import org.dsa.iot.dslink.node.value.Value;
import org.dsa.iot.dslink.node.value.ValueType;
import org.dsa.iot.dslink.util.StringUtils;
import org.dsa.iot.dslink.util.handler.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitpoolConn {
	private final static Logger LOGGER;
	static {
        LOGGER = LoggerFactory.getLogger(BitpoolConn.class);
    }
	
	Node node;
	BitpoolLink link;
	
	final private Node statNode;
	
	final ApiClient apiClient = new ApiClient();
	final AuthenticationApi authApi = new AuthenticationApi(apiClient);
	final PoolsApi poolsApi = new PoolsApi(apiClient);
	
	Map<String, String> timezones = null;

	public BitpoolConn(BitpoolLink link, Node node) {
		this.link = link;
		this.node = node;
		this.statNode = node.createChild("STATUS").setValueType(ValueType.STRING).setValue(new Value("Not logged in")).build();
		this.statNode.setSerializable(false);
	}
	
	void init() {
		
		Action act = new Action(Permission.READ, new RemoveHandler());
		Node anode = node.getChild("remove");
        if (anode == null) node.createChild("remove").setAction(act).build().setSerializable(false);
        else anode.setAction(act);
        
        act = new Action(Permission.READ, new LoginHandler());
		act.addParameter(new Parameter("Email", ValueType.STRING, node.getAttribute("Email")));
		Parameter param = new Parameter("Password", ValueType.STRING, node.getAttribute("Password"));
		param.setEditorType(EditorType.PASSWORD);
		act.addParameter(param);
		act.addParameter(new Parameter("Organisation", ValueType.STRING, node.getAttribute("Organisation")));
		act.addParameter(new Parameter("Place", ValueType.STRING, node.getAttribute("Place")));
		act.addParameter(new Parameter("Polling interval", ValueType.NUMBER, node.getAttribute("Polling interval")));
		act.addParameter(new Parameter("Load data manually", ValueType.BOOL, node.getAttribute("Load data manually")));
		anode = node.getChild("edit");
		if (anode == null) node.createChild("edit").setAction(act).build().setSerializable(false);
		else anode.setAction(act);
        
//        act = new Action(Permission.READ, new UpdateIntervalHandler());
//        act.addParameter(new Parameter("Polling interval", ValueType.NUMBER, node.getAttribute("Polling interval")));
//        anode = node.getChild("edit polling interval");
//        if (anode == null) node.createChild("edit polling interval").setAction(act).build().setSerializable(false);
//        else anode.setAction(act);
		
		if (node.getAttribute("API key") != null) {
			String apiKey = node.getAttribute("API key").getString();
			//apiClient.setApiKeyPrefix(apiKey.split(" ")[0]);
			apiClient.setApiKey(apiKey);
			
			if (timezones == null) {
				List<BitPoolInfrastructureDTOTimeZoneDto> tzList = null;
				try {
					tzList = new TimezonesApi(apiClient).timezonesTimeZones();
				} catch (ApiException e) {
					LOGGER.debug("", e);
					// TODO Auto-generated catch block
				} catch (Exception e) {
					LOGGER.debug("", e);
				}
				if (tzList != null && tzList.size()>0) {
					timezones = new HashMap<String, String>();
					for (BitPoolInfrastructureDTOTimeZoneDto tz: tzList) {
						timezones.put(tz.getDisplayName(), tz.getId());
					}
				}
			}
			
			//node.removeChild("login");
			
			statNode.setValue(new Value("Logged In"));
			
			if (node.getAttribute("Load data manually").getBool()) {
				act = new Action(Permission.READ, new Handler<ActionResult>() {
					public void handle(ActionResult event) {
						loadPools();
					}
				});
				anode  = node.getChild("load all pools");
				if (anode == null) node.createChild("load all pools").setAction(act).build().setSerializable(false);
				else anode.setAction(act);
				
				act = new Action(Permission.READ, new LoadPoolHandler());
				act.addParameter(new Parameter("Pool key", ValueType.STRING));
				anode = node.getChild("load pool");
				if (anode == null) node.createChild("load pool").setAction(act).build().setSerializable(false);
				else anode.setAction(act);
				
			} else {
				loadPools();
			}
				
			act = new Action(Permission.READ, new LogoutHandler());
			anode = node.getChild("logout");
			if (anode == null) node.createChild("logout").setAction(act).build().setSerializable(false);
			else anode.setAction(act);
			
			act = new Action(Permission.READ, new CreatePoolHandler());
			act.addParameter(new Parameter("Poolname", ValueType.STRING));
			act.addParameter(new Parameter("Public", ValueType.BOOL));
			act.addParameter(new Parameter("Virtual", ValueType.BOOL));
			anode = node.getChild("create pool");
			if (anode == null) node.createChild("create pool").setAction(act).build().setSerializable(false);
			else anode.setAction(act);
			
			
		} else {
			
			node.removeChild("logout");
			node.removeChild("create pool");
			
		}
		
	}

	void login(String email, String pass, String org, String place) {
		
		BitPoolInfrastructureDTOAUTHLogin2 logindata = new BitPoolInfrastructureDTOAUTHLogin2();
		logindata.setUsername(email);
		logindata.setPassword(pass);
		logindata.setOrganisation(org);
		logindata.setPlace(place);
		
		try {
			String authkey = new AuthenticationApi().authenticationLogin(logindata);
			//?
			//apiClient.setApiKeyPrefix(authkey.split(" ")[0]);
			apiClient.setApiKey(authkey);
			
			BitPoolInfrastructureDTOCreateAuthKeyDto data = new BitPoolInfrastructureDTOCreateAuthKeyDto();
			data.setKeyType(KeyTypeEnum.STANDARD);
			data.setPlace(place);
			String permKey = authApi.authenticationCreateAuthKey(data);
//			apiClient.setApiKey(permKey);
			node.setAttribute("API key", new Value(permKey));
		} catch (ApiException e) {
			node.removeAttribute("API key");
			statNode.setValue(new Value("Login failed"));
			return;
		}
		
	}
	
	private class LoginHandler implements Handler<ActionResult> {
		public void handle(ActionResult event) {
			String email = event.getParameter("Email", ValueType.STRING).getString();
			String pass = event.getParameter("Password", ValueType.STRING).getString();
			String org = event.getParameter("Organisation", ValueType.STRING).getString();
			String place = event.getParameter("Place", ValueType.STRING).getString();
			double interval = event.getParameter("Polling interval", ValueType.NUMBER).getNumber().doubleValue();
			boolean manLoad = event.getParameter("Load data manually", ValueType.BOOL).getBool();
			
			String name = StringUtils.filterBannedChars(email);
			
			if (!name.equals(node.getName())) {
				Node child = link.node.createChild(name).build();
				child.setAttribute("Email", new Value(email));
				child.setAttribute("Password", new Value(pass));
				child.setAttribute("Organisation", new Value(org));
				child.setAttribute("Place", new Value(place));
				child.setAttribute("Polling interval", new Value(interval));
				child.setAttribute("Load data manually", new Value(manLoad));
				
				BitpoolConn conn = new BitpoolConn(link, child);
				conn.login(email, pass, org, place);
				conn.init();
				remove();
				return;
			}
			
			if (new Value(email).equals(node.getAttribute("Email")) &&
			new Value(pass).equals(node.getAttribute("Password")) &&
			new Value(org).equals(node.getAttribute("Organisation"))) {
				if (!new Value(manLoad).equals(node.getAttribute("Load data manually"))) {
					node.setAttribute("Load data manually", new Value(manLoad));
					clear();
				}
				if (!new Value(place).equals(node.getAttribute("Place"))) {
					node.setAttribute("Place", new Value(place));
					login(email, pass, org, place);
				}
				node.setAttribute("Polling interval", new Value(interval));
				init();
			} else {
				logout();
				
				node.setAttribute("Email", new Value(email));
				node.setAttribute("Password", new Value(pass));
				node.setAttribute("Organisation", new Value(org));
				node.setAttribute("Place", new Value(place));
				node.setAttribute("Polling interval", new Value(interval));
				node.setAttribute("Load data manually", new Value(manLoad));
				
				login(email, pass, org, place);
				init();
			}
			
		}
	}
	
//	private class UpdateIntervalHandler implements Handler<ActionResult> {
//		public void handle(ActionResult event) {
//			double interval = event.getParameter("Polling interval", ValueType.NUMBER).getNumber().doubleValue();
//			node.setAttribute("Polling interval", new Value(interval));
//			init();
//		}
//	}
	
	private class LogoutHandler implements Handler<ActionResult> {
		public void handle(ActionResult event) {
			logout();
			init();
		}
	}
	
	private class RemoveHandler implements Handler<ActionResult> {
		public void handle(ActionResult event) {
			remove();
		}
	}
	
	private void logout() {
		try {
			authApi.authenticationCancelAuthKey(node.getAttribute("API key").getString());
		} catch (ApiException e) {
			LOGGER.debug("", e);
			// TODO Auto-generated catch block
		}
		node.removeAttribute("API key");
		statNode.setValue(new Value("Logged out"));
		//apiClient.setApiKeyPrefix(null);
		apiClient.setApiKey(null);
		clear();
	}
	
	private void clear() {
		if (node.getChildren() == null) return;
		for (Node child: node.getChildren().values()) {
			if (child != statNode && child.getAction() == null) node.removeChild(child);
		}
	}
	
	private void remove() {
		if (node.getAttribute("API key") != null) logout();
		node.clearChildren();
		node.getParent().removeChild(node);
	}
	
	private void loadPools() {
		try {
			List<BitPoolServerModelBitPoolEntity> pools = poolsApi.poolsGetPools();
			for (BitPoolServerModelBitPoolEntity pool: pools) {
				if (node.getChild(pool.getName()) == null) {
					Node child = node.createChild(pool.getName()).build();
					final BitpoolPool bp = makePoolObj(pool, child);
					child.getListener().setOnListHandler(new Handler<Node>() {
						private boolean loaded = false;
						public void handle(Node event) {
							if (!loaded) bp.init();
							loaded = true;
						}
					});
				}
			}
		} catch (ApiException e) {
			LOGGER.debug("", e);
			// TODO Auto-generated catch block
		}
	}
	
	private class LoadPoolHandler implements Handler<ActionResult> {
		public void handle(ActionResult event) {
			String key = event.getParameter("Pool key", ValueType.STRING).getString();
			try {
				BitPoolServerModelBitPoolEntity pool = poolsApi.poolsGetPool(key);
				if (node.getChild(pool.getName()) == null) {
					Node child = node.createChild(pool.getName()).build();
					BitpoolPool bp = makePoolObj(pool, child);
					bp.init();
				}
			} catch (ApiException e) {
				// TODO Auto-generated catch block
				LOGGER.debug("", e);
			}
		}
	}
	
	private class CreatePoolHandler implements Handler<ActionResult> {
		public void handle(ActionResult event) {
			String poolName = event.getParameter("Poolname", ValueType.STRING).getString();
			boolean pub = event.getParameter("Public", ValueType.BOOL).getBool();
			boolean virtual = event.getParameter("Virtual", ValueType.BOOL).getBool();
			
			BitPoolInfrastructureDTOBPRegisterPool data = new BitPoolInfrastructureDTOBPRegisterPool();
			data.setPoolname(poolName);
			data.setPublic(pub);
			data.setVirtual(virtual);
			BitPoolServerModelBitPoolEntity retval;
			try {
				retval = poolsApi.poolsRegisterPool(data);
			} catch (ApiException e) {
				LOGGER.debug("", e);
				// TODO Auto-generated catch block
				return;
			}
			if (retval == null) return;
			Node child = node.createChild(retval.getName()).build();
			
			BitpoolPool bp = makePoolObj(retval, child);
			bp.init();
			
			
		}
	}
	
	private BitpoolPool makePoolObj(BitPoolServerModelBitPoolEntity pool, Node child) {
		child.setAttribute("Pool key", new Value(pool.getPoolKey()));
		child.setAttribute("Registration date", new Value(link.safeToString(pool.getRegistrationDate())));
		child.setAttribute("Public", new Value(pool.getPublic()));
		child.setAttribute("Virtual", new Value(pool.getVirtual()));
		child.setAttribute("Owner", new Value(pool.getOwner()));
		child.setAttribute("Access mode", new Value(pool.getAccessMode().toString()));
		child.setAttribute("Utc offset", new Value(pool.getUtcOffset()));
		child.setAttribute("Time zone", new Value(pool.getTimeZone()));
		
		return new BitpoolPool(getMe(), child);
	}
	
	void restoreLastSession() {
		init();
		if (node.getChildren() == null) return;
		for (Node child: node.getChildren().values()) {
			Value key = child.getAttribute("Pool key");
			if (key != null) {
				try {
					BitPoolServerModelBitPoolEntity pool = poolsApi.poolsGetPool(key.getString());
					BitpoolPool bp = makePoolObj(pool, child);
					bp.restoreLastSession();
				} catch (ApiException e) {
					// TODO Auto-generated catch block
					LOGGER.debug("", e);
					node.removeChild(child);
				}
			} else if (child.getAction() == null && !child.isHidden()) {
				node.removeChild(child);
			}
		}
	}

	BitpoolConn getMe() {
		return this;
	}
	
	

}

