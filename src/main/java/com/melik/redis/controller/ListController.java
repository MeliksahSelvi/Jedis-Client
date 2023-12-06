package com.melik.redis.controller;

import com.melik.redis.model.Programmer;
import com.melik.redis.service.ListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

@RestController
@RequestMapping("/list")
public class ListController {

    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Programmer programmer) {
        listService.addProgrammer(programmer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity get() {
        List<Programmer> programmersList = listService.getProgrammers();
        return ResponseEntity.ok(programmersList);
    }

    @GetMapping("/count")
    public ResponseEntity getCount() {
        Long programmersListCount = listService.getProgrammerCount();
        return ResponseEntity.ok(programmersListCount);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody Programmer programmer) {
        listService.removeProgrammer(programmer);
        return ResponseEntity.ok().build();
    }
}
