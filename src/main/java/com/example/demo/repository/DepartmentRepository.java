package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByStartDateBefore(LocalDate dateBefore);

    List<Department> findByDeptName(String deptName);

    @Query(value = "Select d from Department d where d.startDate = :deptStartDate")
    List<Department> findByDeptStartDate(LocalDate deptStartDate);
}
