package com.example.demo.rest;
import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import com.example.demo.service.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
 @RestController
 @RequiredArgsConstructor
 public class ProjectResource implements ProjectAPI {

     private final ProjectService projectService;

     @Override
     public ResponseEntity<List<Project>> getAllProject() {
         return ResponseEntity.ok(projectService.getAllProject());
     }

     @Override
     public ResponseEntity<Project> createProject(ProjectDTO projectDTO, Long departmentId) {
         Project project = projectService.createProject(projectDTO, departmentId);
         return ResponseEntity.created(URI.create("/api/projects/" + project.getProjectId())).body(project);
     }

     @Override
     public ResponseEntity<Project> getProjectById(Long projectId) {
         return ResponseEntity.ok(projectService.getProjectById(projectId));
     }

     @Override
     public ResponseEntity<Project> updateProjectById(Long projectId, ProjectDTO projectDTO) {
         Project result = projectService.updateProjectById(projectId, projectDTO);
         return ResponseEntity.ok().body(result);
     }

     @Override
     public ResponseEntity<Void> deleteProjectById(Long projectId) {
         projectService.deleteProjectById(projectId);
         return ResponseEntity.noContent().build();
     }

     @Override
     public ResponseEntity<List<Project>> findByProjectArea(String area) {
         return ResponseEntity.ok(projectService.findByProjectArea(area));
     }
 }
