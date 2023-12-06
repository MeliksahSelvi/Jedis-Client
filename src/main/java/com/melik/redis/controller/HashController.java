package com.melik.redis.controller;

import com.melik.redis.model.Programmer;
import com.melik.redis.service.HashService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

@RestController
@RequestMapping("/hash")
public class HashController {

    private final HashService hashService;

    public HashController(HashService hashService) {
        this.hashService = hashService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Programmer programmer) {
        hashService.save(programmer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Programmer programmer) {
        hashService.update(programmer);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping
    public ResponseEntity get() {
        Map<Long, Programmer> programmerMap = hashService.findAll();
        return ResponseEntity.ok(programmerMap);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Programmer programmer = hashService.find(id);
        return ResponseEntity.ok(programmer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        hashService.delete(id);
        return ResponseEntity.ok().build();
    }
}
