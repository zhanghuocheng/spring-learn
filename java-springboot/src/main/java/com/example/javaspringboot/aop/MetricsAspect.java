package com.example.javaspringboot.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MetricsAspect {
    private static final Logger log = LoggerFactory.getLogger(MetricsAspect.class);

    /**
     * 实现一个返回Java基本类型默认值的工具。其实，你也可以逐一写很多if-else判断类型，然后手动设置其默认值。这里为了减少代码量用了一个小技巧，即通过初始化一个具有1个元素的数组，然后通过获取这个数组的值来获取基本类型默认值
     */
    private static final Map<Class<?>, Object> DEFAULT_VALUES = Stream
            .of(boolean.class, byte.class, char.class, double.class, float.class, int.class, long.class, short.class)
            .collect(toMap(clazz -> (Class<?>) clazz, clazz -> Array.get(Array.newInstance(clazz, 1), 0)));

    public static <T> T getDefaultValue(Class<T> clazz) {
        return (T) DEFAULT_VALUES.get(clazz);
    }

    /**
     * @annotation指示器实现对标记了Metrics注解的方法进行匹配
     */
//    @Pointcut("@annotation(com.example.javaspringboot.aop.Metrics)")
    public void withMetricsAnnotation() {
    }

//    @Around("withMetricsAnnotation()")
    public Object metrics(ProceedingJoinPoint pjp) throws Throwable {
        //通过连接点获取方法签名和方法上Metrics注解，并根据方法签名生成日志中要输出的方法定义描述
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Metrics metrics = signature.getMethod().getAnnotation(Metrics.class);

        String name = String.format("【%s】【%s】", signature.getDeclaringType().toString(), signature.toLongString());

        //实现的是入参的日志输出
        if (metrics.logParameters()) {
            log.info(String.format("【入参日志】调用 %s 的参数是：【%s】", name, JSON.toJSONString(pjp.getArgs())));
        }
        //实现连接点方法的执行，以及成功失败的打点，出现异常的时候还会记录日志
        Object returnValue;
        Instant start = Instant.now();
        try {
            returnValue = pjp.proceed();
            if (metrics.recordSuccessMetrics()) {
                //在生产级代码中，我们应考虑使用类似Micrometer的指标框架，把打点信息记录到时间序列数据库中，实现通过图表来查看方法的调用次数和执行时间，在设计篇我们会重点介绍
                log.info(String.format("【成功打点】调用 %s 成功，耗时：%d ms", name, Duration.between(start, Instant.now()).toMillis()));
            }
        } catch (Exception ex) {
            if (metrics.recordFailMetrics()) {
                log.info(String.format("【失败打点】调用 %s 失败，耗时：%d ms", name, Duration.between(start, Instant.now()).toMillis()));
            }
            if (metrics.logException()) {
                log.error(String.format("【异常日志】调用 %s 出现异常！", name), ex);
            }

            //忽略异常的时候，使用一开始定义的getDefaultValue方法，来获取基本类型的默认值
            if (metrics.ignoreException()) {
                returnValue = getDefaultValue(signature.getReturnType());
            } else {
                throw ex;
            }
        }
        //实现了返回值的日志输出
        if (metrics.logReturn()) {
            log.info(String.format("【出参日志】调用 %s 的返回是：【%s】", name, returnValue));
        }
        return returnValue;
    }
}