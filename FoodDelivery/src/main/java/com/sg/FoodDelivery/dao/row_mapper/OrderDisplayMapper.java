package com.sg.FoodDelivery.dao.row_mapper;

import com.sg.FoodDelivery.model.OrderDisplay;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDisplayMapper implements RowMapper<OrderDisplay> {
    @Override
    public OrderDisplay mapRow(ResultSet rs, int i) throws SQLException {
        return new OrderDisplay(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("client_address"),
                rs.getString("name"),
                rs.getString("restaurant_address"),
                rs.getFloat("total_price")
        );
    }
}
