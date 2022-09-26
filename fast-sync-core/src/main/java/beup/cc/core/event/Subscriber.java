package beup.cc.core.event;

public interface Subscriber {

    /**
     * 获取支持的时间类型
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 18:08
     */
    Class<? extends Event> supportEventType();

    /**
     * 处理事件
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 18:11
     */
    void handle(Event event);

}
