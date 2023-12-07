package beup.cc.core.receiver;

import com.alibaba.fastjson.JSONObject;

public class ReceiverFactory {

    private static final String TYPE = "type";

    public static Receiver getReceiver(JSONObject config, SyncContext syncContext) {
        switch (config.getString(TYPE)) {
            case "TimeReceiver":
                return new TimeReceiver(config, syncContext);
            default:
                //todo 抛异常
                throw new RuntimeException("错误的接收者类型");
        }

    }

}
