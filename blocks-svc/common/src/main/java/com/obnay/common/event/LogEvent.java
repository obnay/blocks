package com.obnay.common.event;

import com.obnay.common.base.BaseEntity;

/**
 * 日志事件
 *
 * @author taoyanbo
 * @date 2020-03-23 16:33
 */
public class LogEvent extends AbstractEvent<BaseEntity> {

    public LogEvent(Object source, BaseEntity log) {
        super(source, log);
    }

    public LogEvent(BaseEntity log) {
        super(log);
    }

}
