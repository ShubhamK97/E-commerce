package com.project.e_commerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @NotBlank
    @Size(min = 5,message = "street name should be atleast of 5 length")
    private String street;

    @NotBlank
    @Size(min = 5,message = "buildingName name should be of atleast of 5 length")
    private String buildingName;

    @NotBlank
    @Size(min = 6,message = "pinCode should be atleast of 6 length")
    private String pinCode;

    @NotBlank
    @Size(min = 5,message = "city name should be atleast of 5 length")
    private String city;

    @NotBlank
    @Size(min = 2,message = "State name should be atleast of 2 length")
    private String state;

    @NotBlank
    @Size(min = 2,message = "Country name should be atleast of 2 length")
    private String country;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address(String street, String buildingName, String pinCode, String city, String state, String country) {
        this.street = street;
        this.buildingName = buildingName;
        this.pinCode = pinCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
