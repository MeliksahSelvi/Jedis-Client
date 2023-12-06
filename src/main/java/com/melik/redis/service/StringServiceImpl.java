package com.melik.redis.service;

import com.melik.redis.repo.StringRepository;
import org.springframework.stereotype.Service;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

@Service
public class StringServiceImpl implements StringService {

    private final StringRepository repository;

    public StringServiceImpl(StringRepository repository) {
        this.repository = repository;
    }

    @Override
    public void setProgrammer(String idKey, String programmer) {
        repository.setProgrammer(idKey, programmer);
    }

    @Override
    public String getProgrammer(String idKey) {
        return repository.getProgrammer(idKey);
    }

    @Override
    public void removeProgrammer(String idKey) {
        repository.removeProgrammer(idKey);
    }


}
