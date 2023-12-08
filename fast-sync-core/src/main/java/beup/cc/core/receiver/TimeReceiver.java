package beup.cc.core.receiver;

import beup.cc.core.Record;

import java.util.Map;
import java.util.function.Supplier;

public class TimeReceiver extends AbstractReceiver {

    private final Supplier<Map<String, Object>> supplier;

    private final long timeMillis;

    private long cursorTimeMillis = 0;

    public TimeReceiver(Supplier<Map<String, Object>> supplier, int second) {
        this.supplier = supplier;
        this.timeMillis = second * 1000L;
    }

    /**
     * 获取数据
     */
    @Override
    public Record getData() {
        final long currentTimeMillis = System.currentTimeMillis();
        long dev = currentTimeMillis - cursorTimeMillis;
        if (dev < timeMillis) {
            try {
                Thread.sleep(timeMillis - dev);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cursorTimeMillis = System.currentTimeMillis();
        } else {
            cursorTimeMillis = currentTimeMillis;
        }
        return new Record(supplier.get());
    }

    @Override
    public boolean isEnd() {
        return false;
    }

}
