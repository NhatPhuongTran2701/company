package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.exception.DemoException;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.Mapper.EmployeeMapper;
import com.example.demo.service.dto.CustomEmployeeDTO;
import com.example.demo.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public List<EmployeeDTO> getAllEmployee(){
        return EmployeeMapper.EMPLOYEE_MAPPER.toDtos(employeeRepository.findAll());
    }
     public Employee createEmployee (EmployeeDTO employeeDTO, Long departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);

        Employee employee = new Employee();

        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setGender(employeeDTO.getGender());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
         if(department.isPresent())
             employee.setDepartment(department.get());
         return employeeRepository.save(employee);
     }

     public EmployeeDTO getEmployeeById (Long employeeId) {
        return EmployeeMapper.EMPLOYEE_MAPPER.toDto(employeeRepository.findById(employeeId).orElseThrow(DemoException:: employeeNotFound));
     }

     public Employee updateEmployeeById (Long employeeId, EmployeeDTO employeeDTO) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Employee updateEmployeeById = employee.get();
        updateEmployeeById.setDateOfBirth(employeeDTO.getDateOfBirth());
        updateEmployeeById.setFirstName(employeeDTO.getFirstName());
        updateEmployeeById.setLastName(employeeDTO.getLastName());
        updateEmployeeById.setMiddleName(employeeDTO.getMiddleName());
        updateEmployeeById.setGender(employeeDTO.getGender());
        updateEmployeeById.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(updateEmployeeById);
     }

     public void deleteEmployeeById (long employeeId) {
        employeeRepository.deleteById(employeeId);
     }

     public List<EmployeeDTO> getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        return EmployeeMapper.EMPLOYEE_MAPPER.toDtos(employeeRepository.findByFirstNameAndLastName(firstName, lastName));
     }

     public List<EmployeeDTO> getEmployeeByFirstNameLike(String firstName) {
        return EmployeeMapper.EMPLOYEE_MAPPER.toDtos(employeeRepository.findByFirstNameLike((firstName)));
     }

     public List<EmployeeDTO> getEmployeeByFirstNameOrderBySalaryDesc(String firstName) {
        return EmployeeMapper.EMPLOYEE_MAPPER.toDtos(employeeRepository.findByFirstNameOrderBySalaryDesc(firstName));
     }

     public List<EmployeeDTO> getEmployeeBySalaryLessThan(Long salary) {
        return EmployeeMapper.EMPLOYEE_MAPPER.toDtos(employeeRepository.findBySalaryLessThan((salary)));
     }

     public List<EmployeeDTO> getEmployeeBySalaryIn(List<Long> salaries) {
        return EmployeeMapper.EMPLOYEE_MAPPER.toDtos(employeeRepository.findBySalaryIn(salaries));
     }

     public CustomEmployeeDTO countEmployee(){
        return employeeRepository.countEmployee();
     }

     public CustomEmployeeDTO calculateSumSalary(){
        return employeeRepository.calculateSumSalary();
     }
}
