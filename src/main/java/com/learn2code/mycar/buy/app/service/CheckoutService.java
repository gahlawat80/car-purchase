package com.learn2code.mycar.buy.app.service;

import com.learn2code.mycar.buy.app.dto.CheckoutRequest;
import com.learn2code.mycar.buy.app.entity.Checkout;

import java.util.List;

public interface CheckoutService {
    String saveCarDetailsToCheckout(CheckoutRequest req);

    List<Checkout> fetchAllItemsForCustomer(String customerCode);

    void deleteAllItems(String customerId);
}
