package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.DepartmentLocation;
import com.example.demo.repository.DepartmentLocationRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.Mapper.DepartmentLocationMapper;
import com.example.demo.service.dto.DepartmentLocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentLocationService {
    private final DepartmentLocationRepository departmentLocationRepository;

    private final DepartmentRepository departmentRepository;

    public List<DepartmentLocationDTO> getAllDepartmentLocation(){

        return DepartmentLocationMapper.DEPARTMENT_LOCATION_MAPPER.toDtos(departmentLocationRepository.findAll());
    }
    public DepartmentLocation createDepartmentLocation(DepartmentLocationDTO departmentLocationDTO, Long departmentId){
        Optional<Department> department = departmentRepository.findById(departmentId);

        DepartmentLocation departmentLocation = new DepartmentLocation();

        departmentLocation.setLocation(departmentLocationDTO.getLocation());
        if(department.isPresent())
            departmentLocation.setDepartment(department.get());
        return departmentLocationRepository.save(departmentLocation);
    }

    public DepartmentLocationDTO getDepartmentLocationById (Long deptLocationId) {
        return DepartmentLocationMapper.DEPARTMENT_LOCATION_MAPPER.toDto(departmentLocationRepository.findById(deptLocationId).get());
    }

    public DepartmentLocation updateDepartmentLocationById (Long deptLocationId, DepartmentLocationDTO departmentLocationDTO) {
        Optional<DepartmentLocation> departmentLocation = departmentLocationRepository.findById(deptLocationId);
        DepartmentLocation updateDepartmentLocationById = departmentLocation.get();
        updateDepartmentLocationById.setLocation(departmentLocationDTO.getLocation());
        return departmentLocationRepository.save(updateDepartmentLocationById);
    }

    public void deleteDepartmentLocationById(Long deptLocationId) {
        departmentLocationRepository.deleteById(deptLocationId);
    }
}
