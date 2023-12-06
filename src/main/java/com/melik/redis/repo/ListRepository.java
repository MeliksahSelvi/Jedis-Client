package com.melik.redis.repo;

import com.melik.redis.model.Programmer;

import java.util.List;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

public interface ListRepository {

    void addProgrammer(Programmer programmer);

    List<Object> getProgrammers();

    Long getProgrammersCount();

    void removeProgrammer(Programmer programmer);
}
