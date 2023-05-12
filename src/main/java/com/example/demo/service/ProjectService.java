package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final DepartmentRepository departmentRepository;

    public List<Project> getAllProject(){

        return projectRepository.findAll();
    }
    public Project createProject (ProjectDTO projectDTO, Long departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);

        Project project = new Project();

        project.setProjectName(projectDTO.getProjectName());
        project.setArea(projectDTO.getArea());

        if(department.isPresent())
            project.setDepartment(department.get());
        return projectRepository.save(project);
    }

    public Project getProjectById (Long projectId) {
        return projectRepository.findById(projectId).get();
    }

    public Project updateProjectById (Long projectId, ProjectDTO projectDTO) {
        Project updateProjectById = projectRepository.findById(projectId).get();
        updateProjectById.setProjectName(projectDTO.getProjectName());
        updateProjectById.setArea(projectDTO.getArea());
        return projectRepository.save(updateProjectById);
    }

    public void deleteProjectById (Long projectId) {
        projectRepository.deleteById(projectId);
    }

    public List<Project> findByProjectArea(String area){
        return projectRepository.findByProjectArea(area);
    }
}
