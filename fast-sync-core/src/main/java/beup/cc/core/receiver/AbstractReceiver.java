package beup.cc.core.receiver;

import beup.cc.core.Record;
import beup.cc.core.SyncContext;
import beup.cc.core.transmitter.Transmitter;

import java.util.List;
import java.util.Objects;

public abstract class AbstractReceiver implements Receiver {

    private final String id;

    private volatile boolean isRunning;

    protected final SyncContext syncContext;

    public AbstractReceiver(String id, SyncContext syncContext) {
        this.id = id;
        this.syncContext = syncContext;
    }

    @Override
    public void start() {
        isRunning = true;
        while (isRunning()) {
            final Record record = allowReceive();
            if (Objects.isNull(record)) {
                break;
            }
            final List<Transmitter> transmitterList = this.syncContext.listTransmitter(record.getRowKey());
            transmitterList.stream().parallel().forEach(transmitter ->
                    //todo record深拷贝
                    transmitter.transmit(record));
        }
    }

    @Override
    public void stop() {
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    protected abstract Record allowReceive();

    public String getId() {
        return this.id;
    }

}
