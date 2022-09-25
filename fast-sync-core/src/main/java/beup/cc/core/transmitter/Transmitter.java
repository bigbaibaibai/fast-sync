package beup.cc.core.transmitter;

import beup.cc.core.Record;
import beup.cc.core.writer.Writer;

public interface Transmitter {

   void transmit(Record record);

   boolean isSupport(String rowKey);

   String getId();

   Writer getWriter();

}
