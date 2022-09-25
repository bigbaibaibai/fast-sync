package beup.cc.core.transmitter;

import beup.cc.core.Record;
import beup.cc.core.writer.Writer;
import beup.cc.core.transformer.Transformer;

import java.util.regex.Pattern;

public class SimpleTransmitter implements Transmitter {

    private final String id;

    private final Pattern matchPattern;

    private final Transformer transformer;

    private final Writer writer;

    public SimpleTransmitter(String id, String match, Transformer transformer, Writer writer) {
        this.transformer = transformer;
        this.writer = writer;
        this.id = id;
        this.matchPattern= Pattern.compile(match);
    }

    @Override
    public void transmit(Record record) {
        if (!this.transformer.transform(record)) {
            return;
        }
        this.writer.write(record);
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
        return this.writer;
    }

}
