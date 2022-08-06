package com.learn2code.mycar.buy.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyerInfo {
    private int id;
    private String firstName;
    private String lastName;
    private int addressId;
    private String email;
    private String phone;
    private String driverLicense;
}
