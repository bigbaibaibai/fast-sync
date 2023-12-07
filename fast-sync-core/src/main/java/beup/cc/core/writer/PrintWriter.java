package beup.cc.core.writer;

import beup.cc.core.Record;

public class PrintWriter extends AbstractWriter {

    @Override
    public void write(Record record) {
        System.out.println("写入控制台数据：" + record.getValues());
    }

}
