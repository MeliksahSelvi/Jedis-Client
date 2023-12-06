package com.melik.redis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.melik.redis.model.Programmer;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

public interface StringService {

    void setProgrammer(Programmer programmer) throws JsonProcessingException;

    String getProgrammer(String idKey);

    void removeProgrammer(String idKey);
}
