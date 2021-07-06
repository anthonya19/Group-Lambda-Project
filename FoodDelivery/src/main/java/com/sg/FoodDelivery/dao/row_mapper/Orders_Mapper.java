package com.sg.FoodDelivery.dao.row_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sg.FoodDelivery.model.Order;

public class Orders_Mapper implements RowMapper<Order>
{
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        return new Order(rs.getInt("id"), rs.getInt("client_id"), rs.getInt("driver_id"), rs.getInt("restaurant_id"), rs.getBoolean("is_delivered"), rs.getDate("order_date"),
                         rs.getFloat("total_price"));
    }
}
