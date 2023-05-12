package com.example.demo.service.Mapper;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO toDto(Employee employee);

    List<EmployeeDTO> toDtos(List<Employee> employees);
}
