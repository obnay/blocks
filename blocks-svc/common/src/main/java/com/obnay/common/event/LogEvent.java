package com.obnay.common.event;

import java.util.Map;

/**
 * 日志事件
 *
 * @author taoyanbo
 * @date 2020-03-23 16:33
 */
public class LogEvent extends AbstractEvent<Map<String, Object>> {

    public LogEvent(Object source, Map<String, Object> log) {
        super(source, log);
    }

    public LogEvent(Map<String, Object> log) {
        super(log);
    }

}
