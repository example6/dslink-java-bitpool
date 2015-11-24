package bitpool;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import io.swagger.client.ApiException;
import io.swagger.client.api.LogsApi;
import io.swagger.client.model.BitPoolInfrastructureDTOUpdateStreamDto;
import io.swagger.client.model.BitPoolInfrastructureWebStreamLogsListModel;
import io.swagger.client.model.BitPoolServerModelBitStreamEntity;
import io.swagger.client.model.BitPoolServerModelValueEntity;

import org.dsa.iot.dslink.node.Node;
import org.dsa.iot.dslink.node.Permission;
import org.dsa.iot.dslink.node.actions.Action;
import org.dsa.iot.dslink.node.actions.ActionResult;
import org.dsa.iot.dslink.node.actions.Parameter;
import org.dsa.iot.dslink.node.value.Value;
import org.dsa.iot.dslink.node.value.ValueType;
import org.dsa.iot.dslink.util.handler.CompleteHandler;
import org.dsa.iot.dslink.util.handler.Handler;
import org.dsa.iot.historian.database.Database;
import org.dsa.iot.historian.stats.GetHistory;
import org.dsa.iot.historian.utils.QueryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitpoolStream {
	private final static Logger LOGGER;
	static {
        LOGGER = LoggerFactory.getLogger(BitpoolStream.class);
    }

	Node node;
	BitpoolStation station;
	final LogsApi logsApi;
	Date lastTimestamp;
	
	public BitpoolStream(BitpoolStation station, Node node) {
		this.station = station;
		this.node = node;
		logsApi = new LogsApi(station.pool.conn.apiClient);
		try {
			lastTimestamp = station.pool.conn.link.dateFormat.parse(node.getAttribute("Registration date").getString());
		} catch (ParseException e) {
			lastTimestamp = new Date();
		}
	}
	
	void init() {
		
		if (station.pool.conn.node.getAttribute("Load data manually").getBool()) {
			Action act = new Action(Permission.READ, new Handler<ActionResult>() {
				public void handle(ActionResult event) {
					remove();
				}
			});
			node.createChild("unload").setAction(act).build().setSerializable(false);
		}
		
		station.pool.conn.link.setupStream(this);
		
		GetHistory.initAction(node, new Db());
		
		Action act = new Action(Permission.READ, new DeleteHandler());
		node.createChild("delete").setAction(act).build().setSerializable(false);
		
		makeEditAction();
		
//		ValueType vt = getValueType();
//		act = new Action(Permission.READ, new UploadLogHandler());
//		act.addParameter(new Parameter("Value", vt));
//		act.addParameter(new Parameter("Calculated", ValueType.BOOL));
//		node.createChild("upload log").setAction(act).build().setSerializable(false);
		
	}
	
	private void makeEditAction() {
		Action act = new Action(Permission.READ, new EditHandler());
		act.addParameter(new Parameter("Name", ValueType.STRING, new Value(node.getName())));
		act.addParameter(new Parameter("Description", ValueType.STRING, node.getAttribute("Description")));
		Node anode = node.getChild("edit");
		if (anode == null) node.createChild("edit").setAction(act).build().setSerializable(false);
		else anode.setAction(act);
	}
	
	private class DeleteHandler implements Handler<ActionResult> {
		public void handle(ActionResult event) {
			try {
				station.streamsApi.streamsDeleteStream(node.getAttribute("Stream key").getString());
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
	
	private class EditHandler implements Handler<ActionResult> {
		public void handle(ActionResult event) {
			String name = event.getParameter("Name", ValueType.STRING).getString();
			String descr = event.getParameter("Description", ValueType.STRING).getString();
			
			BitPoolInfrastructureDTOUpdateStreamDto data = new BitPoolInfrastructureDTOUpdateStreamDto();
			data.setName(name);
			data.setDescription(descr);
			
			BitPoolServerModelBitStreamEntity stream;
			
			try {
				station.streamsApi.streamsUpdateStream(node.getAttribute("Stream key").getString(), data );
				stream = station.streamsApi.streamsGetRegisteredBitStream(node.getAttribute("Stream key").getString());
			} catch (ApiException e) {
				LOGGER.debug("", e);
				// TODO Auto-generated catch block
				return;
			}
			if (stream != null) {
				
				if (!node.getName().equals(stream.getName())) {
					ValueType vt = (stream.getDataType() == io.swagger.client.model.BitPoolServerModelBitStreamEntity.DataTypeEnum.DECIMAL) ? ValueType.NUMBER : ValueType.STRING;
					Node old = node;
					node = old.getParent().createChild(stream.getName()).setValueType(vt).build();
					old.getParent().removeChild(old);
				}
				
				node.setAttribute("Pool key", new Value(stream.getPoolKey()));
				node.setAttribute("Stream key", new Value(stream.getStreamKey()));
				node.setAttribute("Local index", new Value(stream.getLocalIndex()));
				node.setAttribute("Description", new Value(stream.getDescription()));
				node.setAttribute("Registration date", new Value(station.pool.conn.link.safeToString(stream.getRegistrationDate())));
				node.setAttribute("Last timestamp", new Value(station.pool.conn.link.safeToString(stream.getLastTimestamp())));
				node.setAttribute("First timestamp", new Value(station.pool.conn.link.safeToString(stream.getFirstTimestamp())));
				node.setAttribute("Last value", new Value(stream.getLastValue()));
				node.setAttribute("First value", new Value(stream.getFirstValue()));
				node.setAttribute("Public", new Value(stream.getPublic()));
				node.setAttribute("Virtual", new Value(stream.getVirtual()));
				node.setAttribute("Virtual type", new Value(stream.getVirtualType().toString()));
				node.setAttribute("Recalculate", new Value(stream.getRecalculate()));
				node.setAttribute("Weather", new Value(stream.getWeather()));
				node.setAttribute("Owner", new Value(stream.getOwner()));
				node.setAttribute("Stream logs count", new Value(stream.getStreamLogsCount()));
				node.setAttribute("Post processing type", new Value(stream.getPostProcessingType().toString()));
				node.setAttribute("Data type", new Value(stream.getDataType().toString()));
				
				init();
			}
		}
	}
	
//	private ValueType getValueType() {
//		DataTypeEnum dt = DataTypeEnum.valueOf(node.getAttribute("Data type").getString().toUpperCase());
//		return (dt == DataTypeEnum.DECIMAL) ? ValueType.NUMBER : ValueType.STRING;
//	}
	
//	private class UploadLogHandler implements Handler<ActionResult> {
//		public void handle(ActionResult event) {
//			Value val = event.getParameter("Value", getValueType());
//			boolean calculated = event.getParameter("Calculated", ValueType.BOOL).getBool();
//			BitPoolServerModelSlog data = new BitPoolServerModelSlog();
//			data.setCalculated(calculated);
//			data.setValue(val.getNumber().doubleValue());
//			data.setTimestamp(new Date());
//			List<BitPoolServerModelSlog> datalst = new ArrayList<BitPoolServerModelSlog>();
//			datalst.add(data);
//			
////			BitPoolInfrastructureDTOStreamData data2 = new BitPoolInfrastructureDTOStreamData();
////			data2.setStreamKey(node.getAttribute("Stream key").getString());
////			data2.setValues(datalst);
////			List<BitPoolInfrastructureDTOStreamData> data2lst = new ArrayList<BitPoolInfrastructureDTOStreamData>();
////			data2lst.add(data2);
//			try {
//				String s = logsApi.logsUploadBitStream(node.getAttribute("Stream key").getString(), datalst);
////				String s = logsApi.logsUploadBitStreams(data2lst);
//				LOGGER.debug(s);
//			} catch (ApiException e) {
//				LOGGER.debug("", e);
//				// TODO Auto-generated catch block
//			}
//		}
//	}
	
	void poll() {
		
		String streamKey = node.getAttribute("Stream key").getString();
		Date from = lastTimestamp;
		Date to = new Date();
		try {
			BitPoolInfrastructureWebStreamLogsListModel data = logsApi.logsGetStreamValues(streamKey , from, to, null, null, null, null, null);
			List<BitPoolServerModelValueEntity> lst = data.getData();
			if (lst.size() > 0) {
				BitPoolServerModelValueEntity last = lst.get(lst.size()-1);
				node.setValue(new Value(last.getValue()));
				node.setAttribute("Last timestamp", new Value(station.pool.conn.link.safeToString(last.getTimestamp())));
				lastTimestamp = to;
			}
		} catch (ApiException e) {
			LOGGER.debug("", e);
			// TODO Auto-generated catch block
		}
	}
	
	private class Db extends Database {

		public Db() {
			super(node.getName(), null);
		}

		@Override
		public void write(String path, Value value, long ts) {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void query(String path, long from, long to, CompleteHandler<QueryData> handler) {
			String streamKey = node.getAttribute("Stream key").getString();
			Date f = new Date(from);
			Date t = new Date(to);
			try {
				BitPoolInfrastructureWebStreamLogsListModel data = logsApi.logsGetStreamValues(streamKey, f, t, null, null, null, null, null);
				for (BitPoolServerModelValueEntity log : data.getData()) {
					QueryData qd = new QueryData(new Value(log.getValue()), log.getTimestamp().getTime());
					handler.handle(qd);
				}
			} catch (ApiException e) {
				// TODO Auto-generated catch block
				LOGGER.debug("", e);
			} finally {
				handler.complete();
			}
		}

		@Override
		public QueryData queryFirst(String path) {
			throw new UnsupportedOperationException();
		}

		@Override
		public QueryData queryLast(String path) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void close() throws Exception {
			throw new UnsupportedOperationException();
			
		}

		@Override
		protected void performConnect() throws Exception {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void initExtensions(Node node) {
			throw new UnsupportedOperationException();
			
		}
		
	}

}