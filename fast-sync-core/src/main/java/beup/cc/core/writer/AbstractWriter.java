package beup.cc.core.writer;

import beup.cc.core.Record;
import beup.cc.core.SyncContext;
import com.alibaba.fastjson.JSONObject;

public abstract class AbstractWriter implements Writer {

    private static final String ID_PARAM = "id";

    private boolean isRunning;

    private final String id;

    private final SyncContext syncContext;

    protected final JSONObject param;

    public AbstractWriter(JSONObject param, SyncContext syncContext) {
        this.param = param;
        this.id = param.getString(ID_PARAM);
        this.syncContext = syncContext;
    }

    @Override
    public void start() {
        isRunning = true;
    }

    @Override
    public void stop() {
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void write(Record record, JSONObject param) {
        if (isRunning()) {
            doWrite(record, param);
        } else {
            //todo 报错，写入器被关闭，却仍有数据需要往里写入，正确流程 ，先移除Transmitter，再关闭Writer
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public SyncContext getSyncContext() {
        return syncContext;
    }

    @Override
    public JSONObject getParam() {
        return param;
    }

    protected abstract void doWrite(Record record, JSONObject param);

}
