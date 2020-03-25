package com.obnay.common.base;

import com.obnay.common.constant.EntityEventEnum;
import com.obnay.common.event.EntityEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import javax.persistence.*;

/**
 * 实体监听器
 *
 * @author taoyanbo
 * @date 2020-03-24 15:39
 */
@Slf4j
public class BaseEntityListener {

    @Autowired
    protected ApplicationEventPublisher eventPublisher;

    /**
     * 新增之前
     */
    @PrePersist
    private void prePersist(BaseEntity entity) {
        eventPublisher.publishEvent(new EntityEvent(this, entity, EntityEventEnum.PRE_PERSIST));
    }

    /**
     * 删除之前
     */
    @PreRemove
    private void preRemove(BaseEntity entity) {
        eventPublisher.publishEvent(new EntityEvent(this, entity, EntityEventEnum.PRE_REMOVE));
    }

    /**
     * 新增之后
     *
     * @param entity
     */
    @PostPersist
    private void postPersist(BaseEntity entity) {
        eventPublisher.publishEvent(new EntityEvent(this, entity, EntityEventEnum.POST_PERSIST));
    }

    /**
     * 删除之后
     *
     * @param entity
     */
    @PostRemove
    private void postRemove(BaseEntity entity) {
        eventPublisher.publishEvent(new EntityEvent(this, entity, EntityEventEnum.POST_REMOVE));
    }

    /**
     * 更新之前
     *
     * @param entity
     */
    @PreUpdate
    private void preUpdate(BaseEntity entity) {
        eventPublisher.publishEvent(new EntityEvent(this, entity, EntityEventEnum.PRE_UPDATE));
    }

    /**
     * 更新之后
     *
     * @param entity
     */
    @PostUpdate
    private void postUpdate(BaseEntity entity) {
        eventPublisher.publishEvent(new EntityEvent(this, entity, EntityEventEnum.POST_UPDATE));
    }

    /**
     * 加载之后
     */
    @PostLoad
    private void postLoad(BaseEntity entity) {
        eventPublisher.publishEvent(new EntityEvent(this, entity, EntityEventEnum.POST_LOAD));
    }

}
