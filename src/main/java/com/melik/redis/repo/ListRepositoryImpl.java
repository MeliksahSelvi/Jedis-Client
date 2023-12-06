package com.melik.redis.repo;

import com.melik.redis.model.Programmer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

@Repository
public class ListRepositoryImpl implements ListRepository {

    private static final String REDIS_LIST_KEY = "ProgrammerList";

    private final RedisTemplate<String, Object> redisTemplate;

    public ListRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void addProgrammer(Programmer programmer) {
        redisTemplate.opsForList().rightPush(REDIS_LIST_KEY, programmer);
    }

    @Override
    public List<Object> getProgrammers() {
        return redisTemplate.opsForList().range(REDIS_LIST_KEY, 0, -1);
    }

    @Override
    public Long getProgrammersCount() {
        return redisTemplate.opsForList().size(REDIS_LIST_KEY);
    }

    @Override
    public void removeProgrammer(Programmer programmer) {
        redisTemplate.opsForList().remove(REDIS_LIST_KEY, 1, programmer);
    }
}
