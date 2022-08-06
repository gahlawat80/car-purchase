package com.learn2code.mycar.buy.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private int id;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
}
