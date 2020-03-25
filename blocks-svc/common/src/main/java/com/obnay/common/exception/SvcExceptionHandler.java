package com.obnay.common.exception;

import com.obnay.common.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @author taoyanbo
 * @date 2020-03-24 16:52
 */
@RestControllerAdvice
@Slf4j
public class SvcExceptionHandler {

    /**
     * 系统自定义异常处理器
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(SvcException.class)
    public Result svcExceptionHandler(SvcException exception) {
        log.error(exception.getMessage(), exception);
        return new Result().error(exception.getMessage());
    }
}
