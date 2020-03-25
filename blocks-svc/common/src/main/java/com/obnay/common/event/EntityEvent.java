package com.obnay.common.event;

import com.obnay.common.base.BaseEntity;
import com.obnay.common.constant.EntityEventEnum;

/**
 * 实体事件
 *
 * @author taoyanbo
 * @date 2020-03-23 16:33
 */
public class EntityEvent extends AbstractEvent<BaseEntity> {

    /**
     * 事件类型
     */
    private EntityEventEnum eventType;

    public EntityEvent(Object source, BaseEntity entity, EntityEventEnum eventType) {
        super(source, entity);
        this.eventType = eventType;
    }

    public EntityEvent(BaseEntity entity, EntityEventEnum eventType) {
        super(entity);
        this.eventType = eventType;
    }

    public EntityEventEnum getEventType() {
        return eventType;
    }

    public void setEventType(EntityEventEnum eventType) {
        this.eventType = eventType;
    }
}
