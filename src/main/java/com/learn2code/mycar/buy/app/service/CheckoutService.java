package com.learn2code.mycar.buy.app.service;

import com.learn2code.mycar.buy.app.dto.CheckoutRequest;
import com.learn2code.mycar.buy.app.entity.Checkout;
import com.learn2code.mycar.buy.app.exception.DetailsNotFoundException;

import java.util.List;

public interface CheckoutService {
    String saveCarDetailsToCheckout(CheckoutRequest req);

    List<Checkout> fetchAllItemsForCustomer(String customerCode);

    Checkout updateItem(int id, Checkout checkout) throws DetailsNotFoundException;

    void deleteItemById(int id) throws DetailsNotFoundException;

    void deleteAllItems(String customerId);

    Checkout findItemById(int id);
}
