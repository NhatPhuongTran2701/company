package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long EmployeeId;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "last_name", length = 20)
    private String lastName;

    @Column(name = "middle_name", length = 20)
    private String middleName;

    @Column(name = "salary")
    private Long salary;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;
}
