package com.learn2code.mycar.buy.app.controller;

import com.learn2code.mycar.buy.app.dto.CheckoutRequest;
import com.learn2code.mycar.buy.app.entity.Checkout;
import com.learn2code.mycar.buy.app.exception.DetailsNotFoundException;

import com.learn2code.mycar.buy.app.service.CheckoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/checkout")
public class CheckoutController {

    Logger LOG = LoggerFactory.getLogger(CheckoutController.class);

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping
    public ResponseEntity<String> saveCheckout(@RequestBody CheckoutRequest request){
        String checkoutRes = checkoutService.saveCarDetailsToCheckout(request);
        LOG.info("******Saved items to checkout********");
        return ResponseEntity.status(HttpStatus.CREATED).body(checkoutRes);
    }

    @GetMapping
    public ResponseEntity<List<Checkout>> getAllItemsForCustomer(){
        String customerId = "123";
        List<Checkout> items = checkoutService.fetchAllItemsForCustomer(customerId);
        LOG.info("********Checkout items from db**********{}",items);
        return new ResponseEntity<>(items,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Checkout> updateCheckout(@PathVariable int id, @RequestBody Checkout checkout) throws DetailsNotFoundException {
        Checkout updatedRecord = checkoutService.updateItem(id,checkout);
        LOG.info("********Checkout single item from db after update**********{} for {}",updatedRecord,id);
        return ResponseEntity.ok(updatedRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable int id) throws DetailsNotFoundException {
            checkoutService.deleteItemById(id);
            return new ResponseEntity<>("Checkout item with id-"+id+" is deleted successfully!",HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll(){
        String customerId="123";
        try{
            checkoutService.deleteAllItems(customerId);
            LOG.info("***********All Items deleted**************");
            return ResponseEntity.ok("All checkout items deleted!");
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
