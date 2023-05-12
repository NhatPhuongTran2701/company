package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.AssignmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.dto.AssignmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Assignment createAssignments(AssignmentDTO assignmentDTO, Long employeeId, Long projectId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Optional<Project> project = projectRepository.findById(projectId);

        Assignment assignment = new Assignment();

        assignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        if (employee.isPresent()) {
            assignment.setEmployee(employee.get());
        }
        if (project.isPresent()) {
            assignment.setProject(project.get());
        }
        return assignmentRepository.save(assignment);
    }

    public Assignment getAssignmentById(Long assignmentId) {
        return assignmentRepository.findById(assignmentId).get();
    }

    public Assignment updateAssignmentById(Long assignmentId, AssignmentDTO assignmentDTO) {
        Optional<Assignment> assignment = assignmentRepository.findById(assignmentId);
        Assignment updateAssignmentByID = assignment.get();
        updateAssignmentByID.setNumberOfHour(assignmentDTO.getNumberOfHour());
        return assignmentRepository.save(updateAssignmentByID);
    }

    public void deleteAssignmentById(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }
}
