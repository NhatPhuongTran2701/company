package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.CustomEmployeeDTO;
import com.example.demo.service.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    List<Employee> findByFirstNameLike(String firstName);

    List<Employee> findByFirstNameOrderBySalaryDesc(String firstName);

    List<Employee> findBySalaryLessThan(Long salary);

    List<Employee> findBySalaryIn(List<Long> salary);

    @Query(value = "SELECT new com.example.demo.service.dto.CustomEmployeeDTO(count(e.EmployeeId)) FROM Employee e")
    CustomEmployeeDTO countEmployee();

    @Query(value = "SELECT new com.example.demo.service.dto.CustomEmployeeDTO(sum(e.salary)) FROM Employee e")
    CustomEmployeeDTO calculateSumSalary();
}
