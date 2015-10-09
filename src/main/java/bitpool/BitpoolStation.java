package bitpool;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.swagger.client.ApiException;
import io.swagger.client.api.StreamsApi;
import io.swagger.client.model.BitPoolInfrastructureDTOBPRegisterStream;
import io.swagger.client.model.BitPoolInfrastructureDTOBPRegisterStream.DataTypeEnum;
import io.swagger.client.model.BitPoolServerModelBitStreamEntity;

import org.dsa.iot.dslink.node.Node;
import org.dsa.iot.dslink.node.Permission;
import org.dsa.iot.dslink.node.actions.Action;
import org.dsa.iot.dslink.node.actions.ActionResult;
import org.dsa.iot.dslink.node.actions.Parameter;
import org.dsa.iot.dslink.node.value.Value;
import org.dsa.iot.dslink.node.value.ValueType;
import org.dsa.iot.dslink.util.handler.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitpoolStation {
	private final static Logger LOGGER;
	static {
        LOGGER = LoggerFactory.getLogger(BitpoolStation.class);
    }
	
	Node node;
	BitpoolPool pool;
	
	final StreamsApi streamsApi;

	public BitpoolStation(BitpoolPool pool, Node node) {
		this.pool = pool;
		this.node = node;
		streamsApi = new StreamsApi(pool.conn.apiClient);
	}
	
	void init() {
		
		loadStreams();
		
		Action act = new Action(Permission.READ, new DeleteHandler());
		node.createChild("delete").setAction(act).build().setSerializable(false);
		
		act = new Action(Permission.READ, new CreateStreamHandler());
		act.addParameter(new Parameter("Local index", ValueType.STRING));
		act.addParameter(new Parameter("Stream name", ValueType.STRING));
		act.addParameter(new Parameter("Description", ValueType.STRING));
		act.addParameter(new Parameter("Public", ValueType.BOOL));
		Set<String> enums = new HashSet<String>();
		for (DataTypeEnum dt: DataTypeEnum.values()) enums.add(dt.toString());
		act.addParameter(new Parameter("Data type", ValueType.makeEnum(enums)));
		node.createChild("create stream").setAction(act).build().setSerializable(false);
		
	}
	
	private class DeleteHandler implements Handler<ActionResult> {
		public void handle(ActionResult event) {
			try {
				pool.conn.poolsApi.poolsDeleteStation(node.getAttribute("Pool key").getString(), node.getAttribute("Station id").getNumber().intValue());
			} catch (ApiException e) {
				LOGGER.debug("", e);
				// TODO Auto-generated catch block
			}
			remove();
		}
	}
	
	private void remove() {
		node.clearChildren();
		node.getParent().removeChild(node);
	}
	
	private class CreateStreamHandler implements Handler<ActionResult> {
		public void handle(ActionResult event) {
			String localIndex = event.getParameter("Local index", ValueType.STRING).getString();
			String name = event.getParameter("Stream name", ValueType.STRING).getString();
			String descr = event.getParameter("Description", ValueType.STRING).getString();
			boolean publ = event.getParameter("Public", ValueType.BOOL).getBool();
			DataTypeEnum dt = DataTypeEnum.DECIMAL;
			try {
				dt = DataTypeEnum.valueOf(event.getParameter("Data type", ValueType.STRING).getString().toUpperCase());
			} catch (IllegalArgumentException e) {}
			
			String poolKey = node.getAttribute("Pool key").getString();
			int stationId = node.getAttribute("Station id").getNumber().intValue();
			BitPoolInfrastructureDTOBPRegisterStream data = new BitPoolInfrastructureDTOBPRegisterStream();
			data.setLocalIndex(localIndex);
			data.setStreamName(name);
			data.setDescription(descr);
			data.setPublic(publ);
			data.setDataType(dt);
			
			BitPoolServerModelBitStreamEntity stream;
			try {
				stream = streamsApi.streamsRegisterBitStream(poolKey, stationId, data);
			} catch (ApiException e) {
				LOGGER.debug("", e);
				// TODO Auto-generated catch block
				return;
			}
			if (stream == null) return;
			
			ValueType vt = (stream.getDataType() == io.swagger.client.model.BitPoolServerModelBitStreamEntity.DataTypeEnum.DECIMAL) ? ValueType.NUMBER : ValueType.STRING;
			Node child = node.createChild(stream.getName()).setValueType(vt).build();
			
			BitpoolStream bs = makeStreamObj(stream, child);
			bs.init();
		}
	}
	
	private void loadStreams() {
		String poolKey = node.getAttribute("Pool key").getString();
		int stationId = node.getAttribute("Station id").getNumber().intValue();
		try {
			List<BitPoolServerModelBitStreamEntity> streams = streamsApi.streamsGetRegisteredBitStreamsAll(poolKey, stationId);
			for (BitPoolServerModelBitStreamEntity stream: streams) {
				ValueType vt = (stream.getDataType() == io.swagger.client.model.BitPoolServerModelBitStreamEntity.DataTypeEnum.DECIMAL) ? ValueType.NUMBER : ValueType.STRING;
				Node child = node.createChild(stream.getName()).setValueType(vt).build();
				final BitpoolStream bs = makeStreamObj(stream, child);
				bs.init();
//				child.getListener().setOnListHandler(new Handler<Node>() {
//					private boolean loaded = false;
//					public void handle(Node event) {
//						if (!loaded) bs.init();
//						loaded = true;
//					}
//				});
			}
		} catch (ApiException e) {
			LOGGER.debug("", e);
			// TODO Auto-generated catch block
		}
	}

	private BitpoolStream makeStreamObj(BitPoolServerModelBitStreamEntity stream, Node child) {
		child.setAttribute("Pool key", new Value(stream.getPoolKey()));
		child.setAttribute("Stream key", new Value(stream.getStreamKey()));
		child.setAttribute("Local index", new Value(stream.getLocalIndex()));
		child.setAttribute("Description", new Value(stream.getDescription()));
		child.setAttribute("Registration date", new Value(pool.conn.link.safeToString(stream.getRegistrationDate())));
		child.setAttribute("Last timestamp", new Value(pool.conn.link.safeToString(stream.getLastTimestamp())));
		child.setAttribute("First timestamp", new Value(pool.conn.link.safeToString(stream.getFirstTimestamp())));
		child.setAttribute("Last value", new Value(stream.getLastValue()));
		child.setAttribute("First value", new Value(stream.getFirstValue()));
		child.setAttribute("Public", new Value(stream.getPublic()));
		child.setAttribute("Virtual", new Value(stream.getVirtual()));
		child.setAttribute("Virtual type", new Value(stream.getVirtualType().toString()));
		child.setAttribute("Recalculate", new Value(stream.getRecalculate()));
		child.setAttribute("Weather", new Value(stream.getWeather()));
		child.setAttribute("Owner", new Value(stream.getOwner()));
		child.setAttribute("Stream logs count", new Value(stream.getStreamLogsCount()));
		child.setAttribute("Post processing type", new Value(stream.getPostProcessingType().toString()));
		child.setAttribute("Data type", new Value(stream.getDataType().toString()));
		
		return new BitpoolStream(getMe(), child);
	}

	private BitpoolStation getMe() {
		return this;
	}
	
	

}
