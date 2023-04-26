package com.example.gtics231lab520203248.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "departments")
public class Department {
    @Id
    private int department_id;
    @Column(nullable = false)
    private String department_name;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
