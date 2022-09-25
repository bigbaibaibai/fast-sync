package beup.cc.core.receiver;

import beup.cc.core.Record;
import beup.cc.core.SyncContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class TestTimeReceiver extends AbstractReceiver {

    private Supplier<Map<String,Object>> contentSupplier;

    private int time = 1000;

    private String rowKey = "test";

    private int batchSize = 1;

    private int maxSize = 100;

    private int count = 0;

    public TestTimeReceiver(String id, SyncContext syncContext) {
        super(id, syncContext);
    }

    @Override
    protected Record allowReceive() {
        count++;

        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Map<String,Object>> content = new ArrayList<>(batchSize);
        for (int i = 0; i < batchSize; i++) {
            content.add(contentSupplier.get());
        }

        if (count > maxSize) {
            stop();
            return null;
        }

        return Record.builder()
                .rowKey(rowKey)
                .values(content)
                .build();
    }

    public void setContentSupplier(Supplier<Map<String,Object>> contentSupplier) {
        this.contentSupplier = contentSupplier;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

}
