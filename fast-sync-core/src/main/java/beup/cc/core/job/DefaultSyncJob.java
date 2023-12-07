package beup.cc.core.job;

import beup.cc.core.Record;
import beup.cc.core.receiver.Receiver;
import beup.cc.core.transformer.Transformer;
import beup.cc.core.writer.Writer;

public class DefaultSyncJob implements SyncJob {

    private final String name;

    private final Receiver receiver;

    private final Transformer transformer;

    private final Writer writer;

    private boolean running;

    public DefaultSyncJob(String name, Receiver receiver, Transformer transformer, Writer writer) {
        this.name = name;
        this.receiver = receiver;
        this.transformer = transformer;
        this.writer = writer;
    }

    @Override
    public void start() {
        running = true;
        for (Record record : receiver) {
            if (!isRunning()) {
                break;
            }
            transformer.transform(record);
            writer.write(record);
        }
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    public String getName() {
        return name;
    }

}
