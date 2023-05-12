package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.CustomEmployeeDTO;
import com.example.demo.service.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/employees")
public interface EmployeeAPI {
    @GetMapping
    ResponseEntity<List<EmployeeDTO>> getAllEmployee();

    @PostMapping("/{deptId}")
    ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable("deptId") Long departmentId);

    @GetMapping("/{employeeId}")
    ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("employeeId") Long employeeId);

    @PutMapping("/{employeeId}")
    ResponseEntity<Employee> updateEmployeeById(@PathVariable("employeeId") Long employeeId, @RequestBody EmployeeDTO employeeDTO);

    @DeleteMapping ("/{employeeId}")
    ResponseEntity<Void> deleteEmployeeById(@PathVariable long employeeId);

    @GetMapping("/get_by_first_name_and_last_name")
    ResponseEntity<List<EmployeeDTO>> getEmployeeByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName);

    @GetMapping("/get_by_first_name_like")
    ResponseEntity<List<EmployeeDTO>> getEmployeeByFirstNameLike(@RequestParam("firstName") String firstName);

    @GetMapping("/get_by_first_name_order_by_salary")
    ResponseEntity<List<EmployeeDTO>> getEmployeeByFirstNameOrderBySalaryDesc(@RequestParam("firstName") String firstName);

    @GetMapping("/get_by_salary_less_than")
    ResponseEntity<List<EmployeeDTO>> getEmployeeBySalaryLessThan(@RequestParam("salary") Long salary);

    @GetMapping("/get_by_salary_in")
    ResponseEntity<List<EmployeeDTO>> getEmployeeBySalaryIn(@RequestParam("salaries") List<Long> salaries);

    @GetMapping("/count_employee")
    ResponseEntity<CustomEmployeeDTO> countEmployee();

    @GetMapping("/get_sum_salary")
    ResponseEntity<CustomEmployeeDTO> calculateSumSalary();
}
