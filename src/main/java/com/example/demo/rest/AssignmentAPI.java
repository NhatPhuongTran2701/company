package com.example.demo.rest;

import com.example.demo.entity.Assignment;
import com.example.demo.service.dto.AssignmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = ("/api/assignments"))
public interface AssignmentAPI{

    @GetMapping
    ResponseEntity<List<Assignment>>getAllAssignments();

    @PostMapping("/employees/{employeeId}/projects/{projectId}")
    ResponseEntity<Assignment> createAssignments(@RequestBody AssignmentDTO assignmentDTO,
                                                 @PathVariable("employeeId") Long employeeId,
                                                 @PathVariable("projectId") Long projectId);

    @GetMapping("/{assignmentId}")
    ResponseEntity<Assignment> getAssignmentById(@PathVariable ("assignmentId") Long assignmentId);

    @PutMapping("/{assignmentId}")
    ResponseEntity<Assignment> updateAssignmentById(@PathVariable ("assignmentId") Long assignmentId, @RequestBody AssignmentDTO assignmentDTO);

    @DeleteMapping("/{assignmentId}")
    ResponseEntity<Void> deleteAssignmentById(@PathVariable("assignmentId") Long assignmentId);
}

