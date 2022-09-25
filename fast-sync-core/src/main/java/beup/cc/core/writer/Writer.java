package beup.cc.core.writer;

import beup.cc.core.LifeCycle;
import beup.cc.core.Record;

public interface Writer extends LifeCycle {

    void write(Record record);

    String getId();

}
