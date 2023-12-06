package com.melik.redis.repo;

import com.melik.redis.model.Programmer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

@Repository
public class SetRepositoryImpl implements SetRepository {

    private static final String REDIS_SET_KEY = "ProgrammerSet";

    private final RedisTemplate<String, Object> redisTemplate;

    public SetRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void addProgrammers(Programmer... programmers) {
        redisTemplate.opsForSet().add(REDIS_SET_KEY, programmers);
    }

    @Override
    public Set<Object> getProgrammersSetMembers() {
        return redisTemplate.opsForSet().members(REDIS_SET_KEY);
    }

    @Override
    public boolean isSetMember(Programmer programmer) {
        return redisTemplate.opsForSet().isMember(REDIS_SET_KEY, programmer);
    }

    @Override
    public void removeProgrammers(Programmer ...programmers) {
        redisTemplate.opsForSet().remove(REDIS_SET_KEY,programmers);
    }
}
