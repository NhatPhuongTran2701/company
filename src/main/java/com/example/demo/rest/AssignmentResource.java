package com.example.demo.rest;

import com.example.demo.entity.Assignment;
import com.example.demo.service.AssignmentService;
import com.example.demo.service.dto.AssignmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssignmentResource implements AssignmentAPI {
    private final AssignmentService assignmentService;

    @Override
    public ResponseEntity<List<Assignment>> getAllAssignments () {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    @Override
    public  ResponseEntity<Assignment> createAssignments (AssignmentDTO assignmentDTO, Long employeeId, Long projectId) {
        Assignment assignment = assignmentService.createAssignments(assignmentDTO, employeeId, projectId);
        return ResponseEntity.created(URI.create("/api/assignments/" + assignment.getId())).body(assignment);
    }

    @Override
    public ResponseEntity<Assignment> getAssignmentById(Long assignmentId) {
        return ResponseEntity.ok(assignmentService.getAssignmentById(assignmentId));
    }

    @Override
    public ResponseEntity<Assignment> updateAssignmentById(Long assignmentId, AssignmentDTO assignmentDTO) {
        Assignment result = assignmentService.updateAssignmentById(assignmentId, assignmentDTO);
        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity<Void> deleteAssignmentById(Long assignmentId) {
        assignmentService.deleteAssignmentById(assignmentId);
        return ResponseEntity.noContent().build();
    }
}
