package com.learn2code.mycar.buy.app.service;

import com.learn2code.mycar.buy.app.dto.CheckoutRequest;

public interface CheckoutService {
    String saveCarDetailsToCheckout(CheckoutRequest req);
}
