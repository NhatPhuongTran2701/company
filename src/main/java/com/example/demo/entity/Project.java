package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQuery(name ="Project.findByProjectArea", query = "SELECT * FROM project WHERE area = ?1", resultClass = Project.class)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    @Column(length = 100)
    private String area;

    @Column(name = "project_name", length = 100)
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "management_department")
    private Department department;
}
