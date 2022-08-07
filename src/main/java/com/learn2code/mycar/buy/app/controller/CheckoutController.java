package com.learn2code.mycar.buy.app.controller;

import com.learn2code.mycar.buy.app.dto.CheckoutRequest;
import com.learn2code.mycar.buy.app.entity.Checkout;
import com.learn2code.mycar.buy.app.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/checkout")
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    @PostMapping
    public ResponseEntity<String> saveCheckout(@RequestBody CheckoutRequest request){
        String checkoutRes = checkoutService.saveCarDetailsToCheckout(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(checkoutRes);
    }

    @GetMapping
    public ResponseEntity<List<Checkout>> getAllItemsForCustomer(){
        String customerId = "123";
        List<Checkout> items = checkoutService.fetchAllItemsForCustomer(customerId);
        return new ResponseEntity<>(items,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Checkout> updateCheckout(@PathVariable int id, @RequestBody Checkout checkout){
        Checkout updatedRecord = checkoutService.updateItem(id,checkout);
        return ResponseEntity.ok(updatedRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable int id){
        try{
            checkoutService.deleteItemById(id);
            return new ResponseEntity<>("Checkout item with id-"+id+" is deleted successfully!",HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
