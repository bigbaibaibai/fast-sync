package beup.cc.core.event;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SyncContextPublisher implements Publisher {

    private final Map<Class<? extends Event>, List<Subscriber>> eventSubscriberMap = new LinkedHashMap<>();

    @Override
    public void publish(Event event) {
        final List<Subscriber> subscriberList = eventSubscriberMap.get(event.getClass());
        if (Objects.nonNull(subscriberList)) {
            for (Subscriber subscriber : subscriberList) {
                subscriber.handle(event);
            }
        }
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        final Class<? extends Event> eventClass = subscriber.supportEventType();
        final List<Subscriber> subscriberList = eventSubscriberMap.get(eventClass);
        if (Objects.nonNull(subscriberList)) {
            subscriberList.add(subscriber);
        } else {
            final List<Subscriber> subscriberNewList = new LinkedList<>();
            subscriberNewList.add(subscriber);
            eventSubscriberMap.put(eventClass, subscriberNewList);
        }
    }

    @Override
    public void deleteSubscriber(Subscriber subscriber) {
        final List<Subscriber> subscriberList = this.eventSubscriberMap.get(subscriber.supportEventType());
        if (Objects.isNull(subscriberList)) {
            return;
        }
        subscriberList.remove(subscriber);
    }

}
