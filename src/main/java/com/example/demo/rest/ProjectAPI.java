package com.example.demo.rest;

import com.example.demo.entity.Project;
import com.example.demo.service.dto.ProjectDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/projects")
public interface ProjectAPI {
    @GetMapping
    ResponseEntity<List<Project>> getAllProject();

    @PostMapping("/{deptid}")
    ResponseEntity<Project> createProject (@RequestBody ProjectDTO projectDTO, @PathVariable("deptid") Long departmentId);

    @GetMapping("/{projectId}")
    ResponseEntity<Project> getProjectById (@PathVariable("projectId") Long projectId);

    @PutMapping("/{projectId}")
    ResponseEntity<Project> updateProjectById (@PathVariable("projectId") Long projectId, @RequestBody  ProjectDTO projectDTO);

    @DeleteMapping("/{projectId}")
    ResponseEntity<Void> deleteProjectById (@PathVariable("projectId") Long projectId);

    @GetMapping("/find_by_project_area")
    ResponseEntity<List<Project>> findByProjectArea(@Param("area") String area);
}
