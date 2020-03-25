package com.obnay.common.base;

import com.obnay.common.event.EntityEvent;
import org.springframework.context.event.EventListener;

/**
 * 基础Service interface
 *
 * @author taoyanbo
 * @date 2020-03-22 00:41
 */
public interface BaseService<E extends BaseEntity> {

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
     * 实体事件监听
     *
     * @param event
     */
    @EventListener(classes = {EntityEvent.class})
    void onEntityEvent(EntityEvent event);

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


}
