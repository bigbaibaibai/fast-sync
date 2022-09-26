package beup.cc.core.receiver.config;

import beup.cc.core.SyncContext;
import beup.cc.core.receiver.Receiver;
import beup.cc.core.receiver.TimeReceiver;

public class TimeReceiverConfig extends BaseReceiverConfig {

    private Integer time = 1000;

    private String rowKey = "test";

    private Integer batchSize = 1;

    private Integer maxSize = 100;

    private Integer count = 0;

    public Integer getTime() {
        return time;
    }

    public String getRowKey() {
        return rowKey;
    }

    public Integer getBatchSize() {
        return batchSize;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public Integer getCount() {
        return count;
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

    public void setCount(int count) {
        this.count = count;
    }

}
