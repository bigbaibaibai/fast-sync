package beup.cc.core;

import beup.cc.core.config.SyncConfig;
import beup.cc.core.receiver.Receiver;
import beup.cc.core.transmitter.Transmitter;
import beup.cc.core.writer.Writer;

import java.util.List;

public interface SyncContext extends LifeCycle {

    /**
     * 添加传输器，负责传输接受到的数据
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 20:37
     */
    void addTransmitter(Transmitter transmitter);

    /**
     * 通过id获取传输器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 22:35
     */
    Transmitter getTransmitter(String id);

    /**
     * 获取匹配传输器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 22:35
     */
    List<Transmitter> listMatchTransmitter(String rowKey);

    /**
     * 获取所有的传输器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 22:36
     */
    List<Transmitter> listTransmitter();

    /**
     * 根据id移除传输器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 22:36
     */
    Transmitter removeTransmitter(String id);

    /**
     * 添加并开启接收器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 20:41
     */
    void addReceiverAndStart(Receiver receiver);

    /**
     * 获取所有接收器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 22:36
     */
    List<Receiver> listReceiver();

    /**
     * 通过 id获取接收器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 22:36
     */
    Receiver getReceiver(String id);

    /**
     * 移除并停止接收器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 22:37
     */
    Receiver removeAndStopReceiver(String id);

    /**
     * 添加并开启写入器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 22:37
     */
    void addAndStartWriter(Writer writer);

    /**
     * 获取所有写入器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 22:37
     */
    List<Writer> listWriter();

    /**
     * 通过id获取写入器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 22:38
     */
    Writer getWriter(String id);

    /**
     * 移除并停止写入器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 22:38
     */
    Writer removeAndStopWriter(String id);

    /**
     * 配置容器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 22:38
     */
    void configuration(SyncConfig syncConfig);

}
