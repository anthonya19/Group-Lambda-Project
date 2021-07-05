package com.sg.FoodDelivery.dao.row_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sg.FoodDelivery.model.OrderItem;

public class Order_Items_Mapper implements RowMapper<OrderItem>
{

    @Override
    public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        return new OrderItem(rs.getInt("id"), rs.getInt("restaurant_id"), rs.getString("name"), rs.getFloat("price"), rs.getString("description"), rs.getInt("order_id"),
                             rs.getInt("quantity"));
    }
}
