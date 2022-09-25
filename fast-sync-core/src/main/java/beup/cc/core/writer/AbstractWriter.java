package beup.cc.core.writer;

import beup.cc.core.Record;

public abstract class AbstractWriter implements Writer {

    private boolean isRunning;

    private final String id;

    public AbstractWriter(String id) {
        this.id = id;
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
    public void write(Record record) {
        if (isRunning()) {
            doWrite(record);
        } else {
            //todo 报错，写入器被关闭，却仍有数据需要往里写入，正确流程 ，先移除Transmitter，再关闭Writer
        }
    }

    protected abstract void doWrite(Record record);

    @Override
    public String getId() {
        return id;
    }

}
