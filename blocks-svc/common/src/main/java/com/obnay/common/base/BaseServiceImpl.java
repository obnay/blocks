package com.obnay.common.base;

import com.obnay.common.event.EntityEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.NoSuchElementException;

/**
 * 基础Service implement
 *
 * @author taoyanbo
 * @date 2020-03-22 00:44
 */
@Slf4j
public class BaseServiceImpl<E extends BaseEntity, R extends BaseRepository<E>> implements BaseService<E> {

    @Autowired
    private R repository;

    public R getRepository() {
        return this.repository;
    }

    @Override
    public E save(E e) {
        E result = this.repository.save(e);
        return result;
    }

    @Override
    public E saveAndFlush(E e) {
        E result = this.repository.saveAndFlush(e);
        return result;
    }

    @Override
    public E findById(String id) {
        try {
            return this.repository.findById(id).get();
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    @Override
    public E update(E e) {
        E result = this.repository.save(e);
        return result;
    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);
    }

    @Async
    @Override
    public void onEntityEvent(EntityEvent event) {
        log.info("Entity name:{}, event type:{}", event.getEventData().getClass().getSimpleName(), event.getEventType().name());
    }
}
