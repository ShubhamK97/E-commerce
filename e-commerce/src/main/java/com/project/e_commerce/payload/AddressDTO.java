package com.project.e_commerce.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Integer addressId;
    private String street;
    private String buildingName;
    private String pinCode;
    private String city;
    private String state;
    private String country;
}
