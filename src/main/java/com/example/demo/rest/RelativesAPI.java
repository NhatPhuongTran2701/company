package com.example.demo.rest;

import com.example.demo.entity.Relatives;
import com.example.demo.service.dto.RelativesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/relatives")
public interface RelativesAPI {
    @GetMapping
    ResponseEntity<List<Relatives>> getAllRelatives();

    @PostMapping("/{employeeId}")
    ResponseEntity<Relatives> createRelatives (@RequestBody RelativesDTO relativesDTO, @PathVariable("employeeId") Long employeeId);

    @GetMapping("/{relativesId}")
    ResponseEntity<Relatives> getRelativesById(@PathVariable Long relativesId);

    @PutMapping("/{relativesId}")
    ResponseEntity<Relatives> updateRelativesById(@PathVariable Long relativesId, @RequestBody RelativesDTO relativesDTO);

    @DeleteMapping("/{relativesId}")
    ResponseEntity<Void> deleteRelativesById(@PathVariable Long relativesId);

}
