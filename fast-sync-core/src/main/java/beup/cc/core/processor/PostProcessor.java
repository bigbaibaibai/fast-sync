package beup.cc.core.processor;

import beup.cc.core.Record;
import beup.cc.core.receiver.Receiver;
import beup.cc.core.transmitter.Transmitter;

public interface PostProcessor {

    /**
     * 接收消息时
     *
     * @author Bai Xinxiang
     * @since 2022/9/25 23:11
     */
    boolean atReceive(Record record, Receiver receiver);

    /**
     * transmit之前
     *
     * @author Bai Xinxiang
     * @since 2022/9/25 23:11
     */
    boolean beforeTransmit(Record record, Transmitter transmitter);

    /**
     * transmit之后
     *
     * @author Bai Xinxiang
     * @since 2022/9/25 23:12
     */
    void afterTransmit(Record record, Transmitter transmitter);

}
