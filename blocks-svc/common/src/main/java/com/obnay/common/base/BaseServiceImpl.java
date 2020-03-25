package com.obnay.common.base;

import com.obnay.common.event.EntityEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

import java.util.Collection;
import java.util.List;
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

    @Async
    @Override
    public void onEntityEvent(EntityEvent event) {
        log.info("EntityName:{}, EventType:{}", event.getEventData().getClass().getSimpleName(), event.getEventType().name());
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

    @Override
    public void delete(E e) {
        this.repository.delete(e);
    }

    @Override
    public Collection<E> saveBatch(Collection<E> entityList) {
        return this.repository.saveAll(entityList);
    }

    @Override
    public Collection<E> listByIds(Collection<String> ids) {
        return this.repository.findAllById(ids);
    }

    @Override
    public List<E> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public Page<E> findAll(Pageable pageable, Example<E> example) {
        return this.repository.findAll(example, pageable);
    }

    @Override
    public long count() {
        return this.repository.count();
    }

    @Override
    public List<E> finAll(Example<E> example) {
        return this.repository.findAll(example);
    }
}
