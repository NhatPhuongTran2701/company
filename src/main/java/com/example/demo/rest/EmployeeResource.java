package com.example.demo.rest;
import com.example.demo.entity.Employee;
import com.example.demo.exception.DemoException;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.dto.CustomEmployeeDTO;
import com.example.demo.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeResource implements EmployeeAPI{

    private final EmployeeService employeeService;
    @Override
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @Override
    public ResponseEntity<Employee> createEmployee(EmployeeDTO employeeDTO, Long departmentId) {
        Employee employee = employeeService.createEmployee(employeeDTO, departmentId);
        return ResponseEntity.created(URI.create("/api/employees/" + employee.getEmployeeId())).body(employee);
    }

    @Override
    public ResponseEntity<EmployeeDTO> getEmployeeById(Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @Override
    public ResponseEntity<Void> deleteEmployeeById (long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Employee> updateEmployeeById (Long employeeId, EmployeeDTO employeeDTO) {
        Employee result = employeeService.updateEmployeeById(employeeId, employeeDTO);
        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        if(firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank()) {
            throw DemoException.badRequest("EMPLOYEE_BAD_REQUEST", "bad request");
        }
        return ResponseEntity.ok(employeeService.getEmployeeByFirstNameAndLastName(firstName,lastName));
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> getEmployeeByFirstNameLike(String firstName) {
        if(firstName == null || firstName.isBlank()) {
            throw DemoException.badRequest("EMPLOYEE_BAD_REQUEST", "bad request");
        }
        return ResponseEntity.ok(employeeService.getEmployeeByFirstNameLike(firstName));
    }

    @Override
    public  ResponseEntity<List<EmployeeDTO>> getEmployeeByFirstNameOrderBySalaryDesc(String firstName) {
        return ResponseEntity.ok(employeeService.getEmployeeByFirstNameOrderBySalaryDesc(firstName));
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> getEmployeeBySalaryLessThan(Long salary) {
        return ResponseEntity.ok(employeeService.getEmployeeBySalaryLessThan(salary));
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> getEmployeeBySalaryIn(List<Long> salaries) {
        return ResponseEntity.ok(employeeService.getEmployeeBySalaryIn(salaries));
    }

    @Override
    public ResponseEntity<CustomEmployeeDTO> countEmployee() {
        return ResponseEntity.ok(employeeService.countEmployee());
    }

    @Override
    public ResponseEntity<CustomEmployeeDTO> calculateSumSalary() {
        return ResponseEntity.ok(employeeService.calculateSumSalary());
    }
}
