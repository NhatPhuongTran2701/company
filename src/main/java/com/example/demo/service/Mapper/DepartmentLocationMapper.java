package com.example.demo.service.Mapper;

import com.example.demo.entity.DepartmentLocation;
import com.example.demo.service.dto.DepartmentDTO;
import com.example.demo.service.dto.DepartmentLocationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentLocationMapper {
    DepartmentLocationMapper DEPARTMENT_LOCATION_MAPPER = Mappers.getMapper(DepartmentLocationMapper.class);

    DepartmentLocationDTO toDto (DepartmentLocation departmentLocation);
    List<DepartmentLocationDTO> toDtos (List<DepartmentLocation> departmentLocations);
}
