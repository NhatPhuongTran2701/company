package com.example.demo.rest;

import com.example.demo.entity.Department;
import com.example.demo.service.dto.DepartmentDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RequestMapping(value = "/api/departments")
public interface DepartmentAPI {
    @GetMapping
    ResponseEntity<List<DepartmentDTO>> getAllDepartment();

    @PostMapping
    ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO departmentDTO);

    @GetMapping("/{deptId}")
    ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("deptId") Long deptId);

    @PutMapping("/{deptId}")
    ResponseEntity<Department> updateDepartmentById(@PathVariable("deptId") Long deptId,
                                                @RequestBody DepartmentDTO departmentDTO);

    @DeleteMapping("/{deptId}")
    ResponseEntity<Void> deleteDepartmentById(@PathVariable("deptId") Long deptId);

    @GetMapping("/get_by_start_date_before")
    ResponseEntity<List<DepartmentDTO>> getDepartmentByStartDateBefore(@RequestParam("dateBefore") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateBefore);

    @GetMapping("/find_by_dept_name")
    ResponseEntity<List<DepartmentDTO>> findByDeptName(@Param("deptName") String deptName);

    @GetMapping("/find_by_start_date")
    ResponseEntity<List<DepartmentDTO>> findByDeptStartDate(@Param("deptStartDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate deptStartDate);

}
