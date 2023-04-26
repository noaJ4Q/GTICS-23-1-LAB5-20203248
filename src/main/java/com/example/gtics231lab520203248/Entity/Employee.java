package com.example.gtics231lab520203248.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private String email;
    private String password;
    private String phone_number;
    @Column(nullable = false)
    private String hire_date;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private Float salary;
    private Float commission_pct;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private int enabled;
}
