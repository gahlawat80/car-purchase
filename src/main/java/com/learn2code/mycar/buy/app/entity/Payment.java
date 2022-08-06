package com.learn2code.mycar.buy.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
    private int id;
    private String fullName;
    private String cardNumber;
    private int cvvNumber;
    private String expiryDate;
}
