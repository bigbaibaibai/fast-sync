package beup.cc.core.plugin;

import beup.cc.core.Record;
import beup.cc.core.receiver.Receiver;
import beup.cc.core.transformer.Transformer;
import beup.cc.core.transmitter.Transmitter;

public interface RecordLifeCyclePlugin {

    /**
     * 消息接收到时
     *
     * @author Bai Xinxiang
     * @since 2022/9/25 23:11
     */
    default void atReceive(Record record, Receiver receiver) {
    }

    /**
     * 数据传输执行之前
     *
     * @author Bai Xinxiang
     * @since 2022/9/25 23:11
     */
    default void beforeTransmit(Record record, Transmitter transmitter) {
    }

    /**
     * 数据传输成功时调用
     *
     * @author Bai Xinxiang
     * @since 2022/9/25 23:12
     */
    default void afterTransmit(Record record, Transmitter transmitter) {
    }

    /**
     * 数据写入之前执行
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 20:24
     */
    default void beforeWrite(Record record, Transformer transformer) {
    }

}
