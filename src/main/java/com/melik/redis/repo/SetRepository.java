package com.melik.redis.repo;

import com.melik.redis.model.Programmer;

import java.util.Set;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

public interface SetRepository {

    void addProgrammers(Programmer ...programmers);

    Set<Object> getProgrammersSetMembers();

    boolean isSetMember(Programmer programmer);

    void removeProgrammers(Programmer ...programmers);
}
