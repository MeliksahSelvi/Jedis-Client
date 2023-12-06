package com.melik.redis.service;

import com.melik.redis.model.Programmer;

import java.util.Map;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

public interface HashService {

    void save(Programmer programmer);

    void update(Programmer programmer);

    Map<Long, Programmer> findAll();

    Programmer find(Long id);

    void delete(Long id);
}
