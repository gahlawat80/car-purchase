package com.learn2code.mycar.buy.app.service;

import com.learn2code.mycar.buy.app.dto.CheckoutRequest;
import com.learn2code.mycar.buy.app.entity.Checkout;
import com.learn2code.mycar.buy.app.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public Checkout updateItem(int id, Checkout checkout) {
        Checkout dbItem = checkoutRepository.findItemById(id);
        if(Objects.nonNull(checkout)){
            if(checkout.getCustomerCode() !="" && checkout.getCustomerCode() !=null){
                dbItem.setCustomerCode(checkout.getCustomerCode());
            }
            if(checkout.getCarDetail() != null && checkout.getCarDetail() !=""){
                dbItem.setCarDetail(checkout.getCarDetail());
            }
            if(checkout.getQuantity() >0){
                dbItem.setQuantity(checkout.getQuantity());
                double totalTax = dbItem.getQuantity()*dbItem.getTaxRate()*dbItem.getUnitPrice()/100;
                dbItem.setTotalTax(totalTax);
                double totalPrice = (dbItem.getQuantity()*dbItem.getUnitPrice())+totalTax;
                dbItem.setTotalPrice(totalPrice);

            }
            if(checkout.getUnitPrice() >0){
                dbItem.setUnitPrice(checkout.getUnitPrice());
                double totalTax = dbItem.getQuantity()*dbItem.getTaxRate()*dbItem.getUnitPrice()/100;
                dbItem.setTotalTax(totalTax);
                double totalPrice = (dbItem.getQuantity()*dbItem.getUnitPrice())+totalTax;
                dbItem.setTotalPrice(totalPrice);
            }
            if(checkout.getTaxRate() >0){
                dbItem.setTaxRate(checkout.getTaxRate());
                double totalTax = dbItem.getQuantity()*dbItem.getTaxRate()*dbItem.getUnitPrice()/100;
                dbItem.setTotalTax(totalTax);
                double totalPrice = (dbItem.getQuantity()*dbItem.getUnitPrice())+totalTax;
                dbItem.setTotalPrice(totalPrice);
            }

            checkoutRepository.updateCarDetails(dbItem);
        }
        return dbItem;
    }

    @Override
    public void deleteItemById(int id) {
        Checkout record = checkoutRepository.findItemById(id);
        if(record !=null ){
            checkoutRepository.deleteById(id);
        } else {
            throw new RuntimeException("Record with id-"+id+" NOT found in DB!");
        }
    }

    @Override
    public void deleteAllItems(String customerId) {
        checkoutRepository.deleteAllCheckoutItems(customerId);
    }

    @Override
    public Checkout findItemById(int id) {
        return checkoutRepository.findItemById(id);
    }
}
