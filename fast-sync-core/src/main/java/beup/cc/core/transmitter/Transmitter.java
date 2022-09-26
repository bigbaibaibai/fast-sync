package beup.cc.core.transmitter;

import beup.cc.core.Record;

public interface Transmitter {

   void transmit(Record record);

   boolean isSupport(String rowKey);

   String getId();

}
