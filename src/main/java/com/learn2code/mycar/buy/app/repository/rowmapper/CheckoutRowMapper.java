package com.learn2code.mycar.buy.app.repository.rowmapper;

import com.learn2code.mycar.buy.app.entity.Checkout;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckoutRowMapper implements RowMapper<Checkout> {
    @Override
    public Checkout mapRow(ResultSet rs, int rowNum) throws SQLException {
        Checkout item = new Checkout();
        item.setId(rs.getInt("id"));
        item.setCustomerCode(rs.getString("customer_code"));
        item.setCarDetail(rs.getString("car_detail"));
        item.setQuantity(rs.getInt("quantity"));
        item.setUnitPrice(rs.getDouble("unit_price"));
        item.setTaxRate(rs.getDouble("tax_rate"));
        item.setTotalTax(rs.getDouble("total_tax"));
        item.setTotalPrice(rs.getDouble("total_price"));
        return item;
    }
}
