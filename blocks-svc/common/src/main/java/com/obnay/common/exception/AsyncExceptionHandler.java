package com.obnay.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * 异步任务异常处理
 *
 * @author taoyanbo
 * @date 2020-03-24 16:42
 */
@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        log.error("AsyncTask executed error, exception message:{},method:{}", throwable.getMessage(), method, throwable);
    }
}
