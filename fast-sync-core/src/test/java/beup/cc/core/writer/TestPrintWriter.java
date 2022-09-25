package beup.cc.core.writer;

import beup.cc.core.Record;
import com.alibaba.fastjson.JSON;

public class TestPrintWriter extends AbstractWriter {

    public TestPrintWriter(String id) {
        super(id);
    }

    @Override
    protected void doWrite(Record record) {
        System.out.println("写入控制台数据：" + JSON.toJSONString(record.getValues()));
    }

}
