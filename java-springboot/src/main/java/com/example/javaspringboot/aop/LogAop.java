package com.example.javaspringboot.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Method;

@Controller
@Aspect
@Slf4j
public class LogAop {


    @Around("execution(* com.example.javaspringboot.controller..*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //先执行业务
        Object result = point.proceed();

        try {
            handle(point);
        } catch (Exception e) {
            log.error("日志记录出错！");
        }

        return result;
    }

    private void handle(ProceedingJoinPoint point) throws Exception {
        // 1. 获取当前拦截的方法名
        MethodSignature sig = (MethodSignature) point.getSignature();
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(sig.getName(), sig.getParameterTypes());
        String methodName = currentMethod.getName();
        log.info("methodName:" + methodName);

        // 2.获取拦截方法的参数
        String className = point.getTarget().getClass().getName();
        Object[] params = point.getArgs();
        log.info("className: " + className);
        System.out.println();
        for (Object param : params) {
            log.info(JSONObject.toJSONString(param));
        }
    }
}

