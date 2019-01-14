package com.cn.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Resource
    public RedisTemplate<String, Object> redisTemplate;

    public String setValue(String key, Object value, long seconds) {
        redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
        return "success";
    }

    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
