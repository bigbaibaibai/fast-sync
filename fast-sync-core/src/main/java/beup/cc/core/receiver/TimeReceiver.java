package beup.cc.core.receiver;

import beup.cc.core.Record;
import beup.cc.core.SyncContext;
import beup.cc.core.util.IfUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class TimeReceiver extends AbstractReceiver {

    private Supplier<Map<String, Object>> contentSupplier;

    private int count = 0;

    private final int time;

    private final String rowKey;

    private final int batchSize;

    private final int maxSize;

    public TimeReceiver(JSONObject param, SyncContext syncContext) {
        super(param, syncContext);
        time = IfUtil.ifNullDefault(param.getInteger("time"), 1000);
        batchSize = IfUtil.ifNullDefault(param.getInteger("batchSize"), 1);
        maxSize = IfUtil.ifNullDefault(param.getInteger("maxSize"), 100);
        rowKey = IfUtil.ifBlankDefault(param.getString("rowKey"), "test");
    }

    @Override
    protected Record allowReceive() {
        count++;

        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Map<String, Object>> content = new ArrayList<>(batchSize);
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

    public void setContentSupplier(Supplier<Map<String, Object>> contentSupplier) {
        this.contentSupplier = contentSupplier;
    }

}
