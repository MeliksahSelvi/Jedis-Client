package com.melik.redis.service;

import com.melik.redis.model.Programmer;
import com.melik.redis.repo.ListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

@Service
public class ListServiceImpl implements ListService {

    private final ListRepository repository;

    public ListServiceImpl(ListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addProgrammer(Programmer programmer) {
        repository.addProgrammer(programmer);
    }

    @Override
    public List<Programmer> getProgrammers() {
        List<Object> programmersList = repository.getProgrammers();
        return programmersList.stream()
                .map(object -> (Programmer) object)
                .collect(Collectors.toList());
    }

    @Override
    public Long getProgrammerCount() {
        return repository.getProgrammersCount();
    }

    @Override
    public void removeProgrammer(Programmer programmer) {
        repository.removeProgrammer(programmer);
    }
}
