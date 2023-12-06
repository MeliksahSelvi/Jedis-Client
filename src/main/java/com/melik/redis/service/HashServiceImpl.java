package com.melik.redis.service;

import com.melik.redis.model.Programmer;
import com.melik.redis.repo.HashRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

@Service
public class HashServiceImpl implements HashService {

    private final HashRepository repository;

    public HashServiceImpl(HashRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Programmer programmer) {
        repository.save(programmer);
    }

    @Override
    public void update(Programmer programmer) {
        repository.update(programmer);
    }

    @Override
    public Map<Long, Programmer> findAll() {
        Map<Object, Object> objectMap = repository.findAll();
        Map<Long, Programmer> programmerMap = new HashMap<>();
        objectMap.entrySet().stream()
                .forEach(entry -> programmerMap.put((Long) entry.getKey(), (Programmer) entry.getValue()));
        return programmerMap;
    }

    @Override
    public Programmer find(Long id) {
        return (Programmer) repository.find(id);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
