package beup.cc.core.receiver;

import beup.cc.core.Record;

import java.util.Iterator;

public interface Receiver extends Iterable<Record> {

    /**
     * 获取数据
     */
    Record getData();

    boolean isEnd();

    default Iterator<Record> iterator() {
        return new Iterator<Record>() {
            @Override
            public boolean hasNext() {
                return !isEnd();
            }

            @Override
            public Record next() {
                return getData();
            }
        };
    }

}
