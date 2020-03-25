package com.obnay.common.base;

import com.obnay.common.event.EntityEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

/**
 * 基础Service interface
 *
 * @author taoyanbo
 * @date 2020-03-22 00:41
 */
public interface BaseService<E extends BaseEntity> {

    /**
     * 实体事件监听
     *
     * @param event
     */
    @EventListener(classes = {EntityEvent.class})
    void onEntityEvent(EntityEvent event);

    /**
     * 保存
     *
     * @param e
     * @return
     */
    E save(E e);

    /**
     * 保存并立即刷新
     *
     * @param e
     * @return
     */
    E saveAndFlush(E e);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    E findById(String id);

    /**
     * 更新
     *
     * @param e
     * @return
     */
    E update(E e);

    /**
     * 删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 删除
     *
     * @param e
     */
    void delete(E e);

    /**
     * 批量保存
     *
     * @param entityList
     * @return
     */
    Collection<E> saveBatch(Collection<E> entityList);

    /**
     * 根据ID查询列表
     *
     * @param ids
     * @return
     */
    Collection<E> listByIds(Collection<String> ids);

    /**
     * 查询全部
     *
     * @return
     */
    List<E> findAll();

    /**
     * 分页查询
     *
     * @param pageable
     * @return
     */
    Page<E> findAll(Pageable pageable);

    /**
     * 分页查询
     *
     * @param pageable
     * @param example
     * @return
     */
    Page<E> findAll(Pageable pageable, Example<E> example);

    /**
     * 查询总数
     *
     * @return
     */
    long count();

    /**
     * 根据Example查询
     *
     * @param example
     * @return
     */
    List<E> finAll(Example<E> example);
}
