package com.example.demo.rest;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentResource implements DepartmentAPI{

    private final DepartmentService departmentService;
    @Override
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @Override
    public ResponseEntity<Department> createDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.created(URI.create("/api/departments/" + department.getDepartmentId())).body(department);
    }

    @Override
    public ResponseEntity<Department> updateDepartmentById(Long deptId, DepartmentDTO departmentDTO) {
        Department result = departmentService.updateDepartmentById(deptId, departmentDTO);
        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity<Void> deleteDepartmentById(Long deptId) {
        departmentService.deleteDepartmentById(deptId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<DepartmentDTO> getDepartmentById (Long deptId) {
        return ResponseEntity.ok(departmentService.getDepartmentById(deptId));
    }

    @Override
    public ResponseEntity<List<DepartmentDTO>> getDepartmentByStartDateBefore(LocalDate dateBefore) {
        return ResponseEntity.ok(departmentService.getDepartmentByStartDateBefore(dateBefore));
    }

    @Override
    public ResponseEntity<List<DepartmentDTO>> findByDeptName(String deptName) {
        return ResponseEntity.ok(departmentService.findByDeptName(deptName));
    }

    @Override
    public ResponseEntity<List<DepartmentDTO>> findByDeptStartDate(LocalDate deptStartDate) {
        return ResponseEntity.ok(departmentService.findByDeptStartDate(deptStartDate));
    }
}

