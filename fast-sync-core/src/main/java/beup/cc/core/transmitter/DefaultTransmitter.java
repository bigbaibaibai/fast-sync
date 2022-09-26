package beup.cc.core.transmitter;

import beup.cc.core.Record;
import beup.cc.core.SyncContext;
import beup.cc.core.config.TransmitterConfig;
import beup.cc.core.transformer.Transformer;
import beup.cc.core.writer.Writer;

import java.util.regex.Pattern;

public class DefaultTransmitter implements Transmitter {

    private final String id;

    private final Pattern matchPattern;

    private final Transformer transformer;

    private final Writer writer;

    private final TransmitterConfig transmitterConfig;

    private final SyncContext syncContext;

    public DefaultTransmitter(TransmitterConfig transmitterConfig, SyncContext syncContext) {
        this.transmitterConfig = transmitterConfig;
        this.id = transmitterConfig.getId();
        this.syncContext = syncContext;
        this.writer = this.syncContext.getWriter(transmitterConfig.getWriterId());
        this.matchPattern = Pattern.compile(transmitterConfig.getMatch());
    }

    @Override
    public void transmit(Record record) {
        if (!this.transformer.transform(record)) {
            return;
        }
        this.writer.write(record, transmitterConfig.getWriteConfig());
    }

    @Override
    public boolean isSupport(String rowKey) {
        return this.matchPattern.matcher(rowKey).matches();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Writer getWriter() {
        return writer;
    }


}
