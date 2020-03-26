package com.obnay.block.sys.log.service;

import com.obnay.block.sys.log.entity.SysLog;
import com.obnay.common.base.BaseService;
import com.obnay.common.event.LogEvent;
import org.springframework.context.event.EventListener;

/**
 * @author taoyanbo
 * @date 2020-03-26 11:24
 */
public interface SysLogService extends BaseService<SysLog> {

    /**
     * 日志事件
     *
     * @param logEvent
     */
    @EventListener(classes = {LogEvent.class})
    void onLogEvent(LogEvent logEvent);
}
