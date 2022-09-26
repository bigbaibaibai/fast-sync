package beup.cc.core.event;

public interface Publisher {

    /**
     * 发布事件
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 18:03
     */
    void publish(Event event);

    /**
     * 注册一个订阅者
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 18:07
     */
    void addSubscriber(Subscriber subscriber);

    /**
     * 移除订阅者
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 18:12
     */
    void deleteSubscriber(Subscriber subscriber);

}
