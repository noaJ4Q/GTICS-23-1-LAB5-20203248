package com.example.gtics231lab520203248.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "regions")
public class Region {
    @Id
    private float region_id;
    private String region_name;
}
