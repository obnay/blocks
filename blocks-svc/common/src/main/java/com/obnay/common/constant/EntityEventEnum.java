package com.obnay.common.constant;

/**
 * 实体事件类型
 *
 * @author taoyanbo
 * @date 2020-03-23 16:56
 */
public enum EntityEventEnum {
    /**
     * 新增之前
     */
    PRE_PERSIST,
    /**
     * 删除之前
     */
    PRE_REMOVE,
    /**
     * 新增之后
     */
    POST_PERSIST,
    /**
     * 删除之后
     */
    POST_REMOVE,
    /**
     * 更新之前
     */
    PRE_UPDATE,
    /**
     * 更新之后
     */
    POST_UPDATE,
    /**
     * 加载之后
     */
    POST_LOAD
}
