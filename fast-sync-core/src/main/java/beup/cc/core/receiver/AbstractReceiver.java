package beup.cc.core.receiver;

import beup.cc.core.Record;
import beup.cc.core.SyncContext;
import beup.cc.core.transmitter.Transmitter;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Objects;

public abstract class AbstractReceiver implements Receiver {

    private static final String ID_PARAM = "id";

    private final String id;

    private volatile boolean isRunning;

    protected final SyncContext syncContext;

    protected JSONObject param;

    public AbstractReceiver(JSONObject param, SyncContext syncContext) {
        this.param = param;
        this.id = param.getString(ID_PARAM);
        this.syncContext = syncContext;
    }

    @Override
    public void start() {
        new Thread(() -> {
            isRunning = true;
            while (isRunning()) {
                final Record record = allowReceive();
                if (Objects.isNull(record)) {
                    break;
                }
                final List<Transmitter> transmitterList = this.syncContext.listMatchTransmitter(record.getRowKey());
                transmitterList.stream().parallel().forEach(transmitter ->
                        //todo record深拷贝
                        transmitter.transmit(record));
            }
        }).start();
    }

    @Override
    public void stop() {
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    public String getId() {
        return this.id;
    }

    public JSONObject getParam() {
        return this.param;
    }

    protected abstract Record allowReceive();


}
