package com.learn2code.mycar.buy.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutRequest {
    private String carDescription;
    private int quantity;
    private double basePrice;
    private double tax;
}
