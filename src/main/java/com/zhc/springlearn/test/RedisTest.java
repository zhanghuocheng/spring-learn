package com.zhc.springlearn.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisTest implements ApplicationRunner {

    @Resource
    private RedisTemplate redisTemplate;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        redisTemplate.opsForValue().set("hello","world0");
        System.out.println("redis test ret="+redisTemplate.opsForValue().get("hello"));
    }
}
