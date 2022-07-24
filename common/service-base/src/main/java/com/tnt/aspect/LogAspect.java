package com.tnt.aspect;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author huangrw
 * @program: SpringBootTemplate
 * @Description 拦截 controller 里所有请求,打印请求 info and responseInfo
 * @createTime 2022年05月05日 22:30:00
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.tnt.*.controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String requestURL = String.valueOf(request.getRequestURL());
        String ip = request.getRemoteAddr();
        String clsaamethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(requestURL, ip, clsaamethod, args);
        log.info("request:{}",requestLog);
    }

    @After("log()")
    public void doAfter(){
        //log.info("doAfter");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturning(Object result){
        log.info("result:{}",result);
    }


    @AllArgsConstructor
    @ToString
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
    }

}
