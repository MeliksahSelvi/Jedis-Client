package com.melik.redis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.melik.redis.model.Programmer;
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
    public void setProgrammer(Programmer programmer) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        repository.setProgrammer(String.valueOf(programmer.getId()), objectMapper.writeValueAsString(programmer));
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
