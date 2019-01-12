package com.cn.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {
    @Resource
    public RedisTemplate<String, Object> redisTemplate;

    public String setValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
        return "success";
    }

    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
