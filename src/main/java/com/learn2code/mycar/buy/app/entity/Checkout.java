package com.learn2code.mycar.buy.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Checkout {
    private int id;
    private String customerCode;
    private String carDetail;
    private int quantity;
    private double unitPrice;
    private double taxRate;
    private double totalTax;
    private double totalPrice;

}
