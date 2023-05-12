package com.example.demo.rest;
import com.example.demo.entity.DepartmentLocation;
import com.example.demo.service.DepartmentLocationService;
import com.example.demo.service.dto.DepartmentLocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentLocationResource implements DepartmentLocationAPI {
    private final DepartmentLocationService departmentLocationService;
    @Override
    public ResponseEntity<List<DepartmentLocationDTO>> getAllDepartmentLocation() {
        return ResponseEntity.ok(departmentLocationService.getAllDepartmentLocation());
    }

    @Override
    public ResponseEntity<DepartmentLocation> createDepartmentLocation(DepartmentLocationDTO departmentLocationDTO, Long departmentId) {
        DepartmentLocation departmentLocation = departmentLocationService.createDepartmentLocation(departmentLocationDTO, departmentId);
        return ResponseEntity.created(URI.create("/api/departmentLocations/" + departmentLocation.getId())).body(departmentLocation);
    }

    @Override
    public ResponseEntity<DepartmentLocationDTO> getDepartmentLocationById(Long deptLocationId) {
        return ResponseEntity.ok(departmentLocationService.getDepartmentLocationById(deptLocationId));
    }

    @Override
    public ResponseEntity<DepartmentLocation> updateDepartmentLocationById(Long deptLocationId, DepartmentLocationDTO departmentLocationDTO) {
        DepartmentLocation result = departmentLocationService.updateDepartmentLocationById(deptLocationId, departmentLocationDTO);
        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity<Void> deleteDepartmentLocationById(Long deptLocationId) {
        departmentLocationService.deleteDepartmentLocationById(deptLocationId);
        return ResponseEntity.noContent().build();
    }
}
