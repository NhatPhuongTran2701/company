package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.Mapper.DepartmentMapper;
import com.example.demo.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getAllDepartment() {

        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findAll());
    }

    public Department createDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(department);
    }

    public DepartmentDTO getDepartmentById(Long deptId) {
        Department department = departmentRepository.findById(deptId).get();
        return DepartmentMapper.INSTANCE.toDto(department);
    }

    public void deleteDepartmentById(Long deptId) {
        departmentRepository.deleteById(deptId);
    }

    public Department updateDepartmentById(Long deptId, DepartmentDTO departmentDTO) {
        Optional<Department> department = departmentRepository.findById(deptId);
        Department updateDepartment = department.get();
        updateDepartment.setDepartmentName(departmentDTO.getDepartmentName());
        updateDepartment.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(updateDepartment);
    }

    public List<DepartmentDTO> getDepartmentByStartDateBefore(LocalDate dateBefore){
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findByStartDateBefore(dateBefore));
    }

    public List<DepartmentDTO> findByDeptName(String deptName){
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findByDeptName(deptName));
    }

    public List<DepartmentDTO> findByDeptStartDate(LocalDate deptStartDate){
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findByDeptStartDate(deptStartDate));
    }

}
