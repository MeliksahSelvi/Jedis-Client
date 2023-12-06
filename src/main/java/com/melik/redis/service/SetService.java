package com.melik.redis.service;

import com.melik.redis.model.Programmer;

import java.util.Set;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

public interface SetService {

    void addProgrammers(Programmer... programmers);

    Set<Programmer> getProgrammersSetMembers();

    boolean isSetMember(Programmer programmer);

    void removeProgrammers(Programmer ...programmers);
}
