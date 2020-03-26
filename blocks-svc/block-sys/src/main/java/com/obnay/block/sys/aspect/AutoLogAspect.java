package com.obnay.block.sys.aspect;

import com.alibaba.fastjson.JSON;
import com.obnay.block.sys.log.entity.SysLog;
import com.obnay.block.sys.user.entity.SysUser;
import com.obnay.common.annotation.AutoLog;
import com.obnay.common.event.LogEvent;
import org.apache.shiro.SecurityUtils;
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
        publishLog(point, time);
        return result;
    }

    private void publishLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLog log = new SysLog();

        AutoLog autoLog = method.getAnnotation(AutoLog.class);
        if (null != autoLog) {
            log.setLogContent(autoLog.value());
            log.setLogType(autoLog.logType());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.setClassName(className);
        log.setMethodName(methodName);

        //请求的参数

        log.setRequestParam(JSON.toJSONString(joinPoint.getArgs()));
        //耗时
        log.setCostTime(time);
        log.setRequestTime(new Date());


        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        if (user != null) {
            log.setUserId(user.getId());
            log.setUserName(user.getRealName());
        }
        //发布日志事件
        eventPublisher.publishEvent(new LogEvent(this, log));
    }
}
