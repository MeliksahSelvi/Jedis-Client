package com.melik.redis.repo;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

@Repository
public class StringRepositoryImpl implements StringRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    public StringRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void setProgrammer(String idKey, String programmer) {
        redisTemplate.opsForValue().set(idKey, programmer);
        redisTemplate.expire(idKey, 1, TimeUnit.MINUTES);
    }

    @Override
    public String getProgrammer(String idKey) {
        return (String) redisTemplate.opsForValue().get(idKey);
    }

    @Override
    public void removeProgrammer(String idKey) {
        redisTemplate.delete(idKey);
    }
}
