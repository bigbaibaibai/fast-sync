package beup.cc.core.writer;

import beup.cc.core.Record;
import beup.cc.core.SyncContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class PrintWriter extends AbstractWriter {

    private static final String PRINT_TYPE = "printType";

    public PrintWriter(JSONObject param, SyncContext syncContext) {
        super(param, syncContext);
    }

    @Override
    protected void doWrite(Record record, JSONObject param) {
        if ("json".equals(param.getString(PRINT_TYPE))) {
            System.out.println("写入控制台数据：" + JSON.toJSONString(record.getValues()));
        } else {
            System.out.println("写入控制台数据：" + record.getValues());
        }
    }

}
