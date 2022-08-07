package com.learn2code.mycar.buy.app.service;

import com.learn2code.mycar.buy.app.dto.CheckoutRequest;
import com.learn2code.mycar.buy.app.entity.Checkout;
import com.learn2code.mycar.buy.app.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    @Autowired
    private CheckoutRepository checkoutRepository;

    @Override
    public String saveCarDetailsToCheckout(CheckoutRequest req) {
        Checkout checkout = new Checkout();
        checkout.setCarDetail(req.getCarDescription());
        checkout.setCustomerCode("123");
        checkout.setQuantity(req.getQuantity());
        checkout.setUnitPrice(req.getBasePrice());
        checkout.setTaxRate(req.getTax());
        checkout.setTotalTax(req.getQuantity()*req.getTax()* req.getBasePrice()/100);
        checkout.setTotalPrice((req.getBasePrice()* req.getQuantity())+checkout.getTotalTax());

        int inserted = checkoutRepository.saveCarDetails(checkout);
        if(inserted==1){
            return "Record inserted successfully in Checkout table!";
        }
        return null;
    }

    @Override
    public List<Checkout> fetchAllItemsForCustomer(String customerCode) {
        return checkoutRepository.fetchAll(customerCode);
    }

    @Override
    public void deleteAllItems(String customerId) {
        checkoutRepository.deleteAllCheckoutItems(customerId);
    }
}
