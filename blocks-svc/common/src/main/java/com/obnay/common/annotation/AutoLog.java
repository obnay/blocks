package com.obnay.common.annotation;

import com.obnay.common.constant.LogTypeEnum;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * @author taoyanbo
 * @date 2020-03-25 11:08
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoLog {

    /**
     * 日志内容
     *
     * @return
     */
    String value() default "";

    /**
     * 日志类型
     *
     * @return
     */
    LogTypeEnum logType() default LogTypeEnum.OP_LOG;
}
