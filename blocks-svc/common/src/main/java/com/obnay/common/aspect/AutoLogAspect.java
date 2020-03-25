package com.obnay.common.aspect;

import com.obnay.common.annotation.AutoLog;
import com.obnay.common.event.LogEvent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统日志切面
 *
 * @author taoyanbo
 * @date 2020-03-25 14:32
 */
@Aspect
@Component
public class AutoLogAspect {

    @Autowired
    protected ApplicationEventPublisher eventPublisher;

    @Pointcut("@annotation(com.obnay.common.annotation.AutoLog)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //保存日志
        publisherLog(point, time);
        return result;
    }

    private void publisherLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Map<String, Object> log = new HashMap<>(16);

        AutoLog autoLog = method.getAnnotation(AutoLog.class);
        if (null != autoLog) {
            log.put("logContent", autoLog.value());
            log.put("logType", autoLog.logType());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.put("class", className);
        log.put("method", methodName);
        //请求的参数
        log.put("args", joinPoint.getArgs());
        //耗时
        log.put("cost", time);
        log.put("createTime", new Date());

        //发布日志事件
        eventPublisher.publishEvent(new LogEvent(this, log));
    }
}
