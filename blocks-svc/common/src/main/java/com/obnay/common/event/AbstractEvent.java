package com.obnay.common.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件源
 *
 * @author taoyanbo
 * @date 2020-03-23 15:57
 */
public abstract class AbstractEvent<T> extends ApplicationEvent {

    protected T eventData;

    public AbstractEvent(Object source, T eventData) {
        super(source);
        this.eventData = eventData;
    }

    public AbstractEvent(T eventData) {
        super(eventData);
    }

    public T getEventData() {
        return eventData;
    }

    public void setEventData(T eventData) {
        this.eventData = eventData;
    }
}
