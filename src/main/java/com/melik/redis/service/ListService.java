package com.melik.redis.service;

import com.melik.redis.model.Programmer;

import java.util.List;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

public interface ListService {

    void addProgrammer(Programmer programmer);

    List<Programmer> getProgrammers();

    Long getProgrammerCount();

    void removeProgrammer(Programmer programmer);
}
