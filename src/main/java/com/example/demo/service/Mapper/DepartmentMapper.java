package com.example.demo.service.Mapper;

import com.example.demo.entity.Department;
import com.example.demo.service.dto.DepartmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDTO toDto(Department department);
    List<DepartmentDTO> toDtos(List<Department> departments);
}
