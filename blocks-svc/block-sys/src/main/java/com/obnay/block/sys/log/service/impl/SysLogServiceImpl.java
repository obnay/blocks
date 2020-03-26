package com.obnay.block.sys.log.service.impl;

import com.obnay.block.sys.log.entity.SysLog;
import com.obnay.block.sys.log.repository.SysLogRepository;
import com.obnay.block.sys.log.service.SysLogService;
import com.obnay.common.base.BaseServiceImpl;
import com.obnay.common.event.LogEvent;
import org.springframework.scheduling.annotation.Async;

/**
 * @author taoyanbo
 * @date 2020-03-26 11:24
 */
public class SysLogServiceImpl extends BaseServiceImpl<SysLog, SysLogRepository> implements SysLogService {

    @Async
    @Override
    public void onLogEvent(LogEvent logEvent) {
        SysLog log = (SysLog) logEvent.getEventData();
        this.save(log);
    }
}
