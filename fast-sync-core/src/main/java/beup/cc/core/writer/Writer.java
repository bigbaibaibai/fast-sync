package beup.cc.core.writer;

import beup.cc.core.LifeCycle;
import beup.cc.core.Record;
import beup.cc.core.SyncContext;
import com.alibaba.fastjson.JSONObject;

public interface Writer extends LifeCycle {

    void write(Record record, JSONObject param);

    String getId();

    SyncContext getSyncContext();

    JSONObject getParam();

}
