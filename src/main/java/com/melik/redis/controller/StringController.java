package com.melik.redis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.melik.redis.model.Programmer;
import com.melik.redis.service.StringService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

@RestController
@RequestMapping("/string")
public class StringController {

    private final StringService stringService;

    public StringController(StringService stringService) {
        this.stringService = stringService;
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        String programmerAsString = stringService.getProgrammer(String.valueOf(id));
        return ResponseEntity.ok(programmerAsString);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Programmer programmer) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        stringService.setProgrammer(String.valueOf(programmer.getId()), objectMapper.writeValueAsString(programmer));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        stringService.removeProgrammer(String.valueOf(id));
        return ResponseEntity.ok().build();
    }
}
