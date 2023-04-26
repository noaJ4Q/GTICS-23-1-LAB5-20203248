package com.example.gtics231lab520203248.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "countries")
public class Country {
    @Id
    private String country_id;
    private String country_name;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}
