package com.melik.redis.controller;

import com.melik.redis.model.Programmer;
import com.melik.redis.service.SetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

@RestController
@RequestMapping("/set")
public class SetController {

    private final SetService setService;

    public SetController(SetService setService) {
        this.setService = setService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Programmer... programmers) {
        setService.addProgrammers(programmers);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity get() {
        Set<Programmer> setMembers = setService.getProgrammersSetMembers();
        return ResponseEntity.ok(setMembers);
    }

    @PostMapping("/member")
    public ResponseEntity isMember(@RequestBody Programmer programmer) {
        boolean isMember = setService.isSetMember(programmer);
        return ResponseEntity.ok(isMember);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody Programmer ...programmers) {
        setService.removeProgrammers(programmers);
        return ResponseEntity.ok().build();
    }
}
