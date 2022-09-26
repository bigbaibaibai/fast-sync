package beup.cc.core.writer;

import beup.cc.core.SyncContext;
import com.alibaba.fastjson.JSONObject;

public class WriterFactory {

    private static final String TYPE = "type";

    public static Writer getWriter(JSONObject config, SyncContext syncContext) {
        switch (config.getString(TYPE)) {
            case "PrintWriter":
                return new PrintWriter(config, syncContext);
            default:
                //todo 抛异常
                throw new RuntimeException("错误的写入类型");
        }
    }

}
