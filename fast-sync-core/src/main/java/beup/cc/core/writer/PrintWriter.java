package beup.cc.core.writer;

import beup.cc.core.Record;

public class PrintWriter extends AbstractWriter {

    public PrintWriter(String id) {
        super(id);
    }

    @Override
    protected void doWrite(Record record) {
        System.out.println("写入控制台数据：" + record.getValues());
    }

}
