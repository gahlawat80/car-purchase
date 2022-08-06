package com.learn2code.mycar.buy.app.repository;

import com.learn2code.mycar.buy.app.entity.Checkout;
import com.learn2code.mycar.buy.app.repository.rowmapper.CheckoutRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CheckoutRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveCarDetails(Checkout checkout){
        String sql = "INSERT INTO checkout(id,customer_code,car_detail,quantity,unit_price,tax_rate,total_tax,total_price) " +
                "VALUES(?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(sql,checkout.getId(),checkout.getCustomerCode(),checkout.getCarDetail(),checkout.getQuantity(),checkout.getUnitPrice(),checkout.getTaxRate(),checkout.getTotalTax(),checkout.getTotalPrice());
    }

    public List<Checkout> fetchAll(String customerCode) {
        String sql = "SELECT * FROM checkout WHERE customer_code=?";
        return jdbcTemplate.query(sql,new CheckoutRowMapper(),customerCode);
    }
}
