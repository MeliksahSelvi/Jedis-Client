package com.melik.redis.repo;

import com.melik.redis.model.Programmer;

import java.util.Map;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

public interface HashRepository {

    void save(Programmer programmer);

    void update(Programmer programmer);

    Map<Object, Object> findAll();

    Object find(Long id);

    void delete(Long id);
}
