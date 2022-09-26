package beup.cc.core.config;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class SyncConfig {

    private final List<JSONObject> receiverConfigList = new LinkedList<>();

    private final List<JSONObject> transmitterConfigList = new LinkedList<>();

    private final List<JSONObject> writerConfigList = new LinkedList<>();

    public List<JSONObject> getReceiverConfigList() {
        return receiverConfigList;
    }

    public List<JSONObject> getTransmitterConfigList() {
        return transmitterConfigList;
    }

    public List<JSONObject> getWriterConfigList() {
        return writerConfigList;
    }

}
