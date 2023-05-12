package com.example.demo.rest;

import com.example.demo.entity.DepartmentLocation;
import com.example.demo.service.dto.DepartmentLocationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/departmentLocations")
public interface DepartmentLocationAPI {
    @GetMapping
    ResponseEntity<List<DepartmentLocationDTO>> getAllDepartmentLocation();

    @PostMapping("/{dept_id}")
    ResponseEntity<DepartmentLocation> createDepartmentLocation (@RequestBody DepartmentLocationDTO departmentLocationDTO, @PathVariable ("dept_id") Long DepartmentId);

    @GetMapping("/{deptLocationId}")
    ResponseEntity<DepartmentLocationDTO> getDepartmentLocationById(@PathVariable ("deptLocationId") Long deptLocation);

    @PutMapping("/{deptLocationId}")
    ResponseEntity<DepartmentLocation> updateDepartmentLocationById(@PathVariable("deptLocationId") Long deptLocationId, @RequestBody DepartmentLocationDTO departmentLocationDTO);

    @DeleteMapping("/{deptLocationId}")
    ResponseEntity<Void> deleteDepartmentLocationById(@PathVariable("deptLocationId") Long deptLocationId);
}
