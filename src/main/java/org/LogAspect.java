package org;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * https://www.jianshu.com/p/00ce2ed403b2  log &&traceId
 */
@Component
@Aspect
@Slf4j
public class LogAspect {
    private static final String POINT_CUT = "execution(public * com.zhc.springlearn.DemoController.*(..))";

    @Pointcut(POINT_CUT)
    private void setPointCut() {
    }

    @Before(value = "setPointCut()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("{},{},{}", request.getRequestURI(), request.getMethod(), joinPoint.getSignature());
    }

    @Around(value = "setPointCut()")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        Object ret = proceedingJoinPoint.proceed();
        log.info("请求信息={},返回信息={}", JSONObject.toJSONString(args), JSONObject.toJSONString(ret));
        return ret;
    }
}
