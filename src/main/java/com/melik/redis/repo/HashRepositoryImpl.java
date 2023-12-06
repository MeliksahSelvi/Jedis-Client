package com.melik.redis.repo;

import com.melik.redis.model.Programmer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

@Repository
public class HashRepositoryImpl implements HashRepository {

    private static final String REDIS_HASH_KEY = "ProgrammerHash";

    private final RedisTemplate<String, Object> redisTemplate;

    public HashRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void save(Programmer programmer) {
        redisTemplate.opsForHash().put(REDIS_HASH_KEY, programmer.getId(), programmer);
    }

    @Override
    public void update(Programmer programmer) {
        redisTemplate.opsForHash().put(REDIS_HASH_KEY, programmer.getId(), programmer);
    }

    @Override
    public Map<Object, Object> findAll() {
        return redisTemplate.opsForHash().entries(REDIS_HASH_KEY);
    }

    @Override
    public Object find(Long id) {
        return redisTemplate.opsForHash().get(REDIS_HASH_KEY, id);
    }

    @Override
    public void delete(Long id) {
        redisTemplate.opsForHash().delete(REDIS_HASH_KEY, id);
    }
}
