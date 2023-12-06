package com.melik.redis.service;

import com.melik.redis.model.Programmer;
import com.melik.redis.repo.SetRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

@Service
public class SetServiceImpl implements SetService {

    private final SetRepository repository;

    public SetServiceImpl(SetRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addProgrammers(Programmer... programmers) {
        repository.addProgrammers(programmers);
    }

    @Override
    public Set<Programmer> getProgrammersSetMembers() {
        Set<Object> setMembers = repository.getProgrammersSetMembers();
        return setMembers.stream()
                .map(object -> (Programmer) object)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isSetMember(Programmer programmer) {
        return repository.isSetMember(programmer);
    }

    @Override
    public void removeProgrammers(Programmer... programmers) {
        repository.removeProgrammers(programmers);
    }
}
