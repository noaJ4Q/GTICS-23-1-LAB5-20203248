package com.example.gtics231lab520203248.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "locations")
public class Location {
    @Id
    private int location_id;
    private String street_address;
    private String postal_code;
    @Column(nullable = false)
    private String city;
    private String state_province;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
