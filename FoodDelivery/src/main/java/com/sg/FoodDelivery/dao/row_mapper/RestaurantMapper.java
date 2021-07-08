package com.sg.FoodDelivery.dao.row_mapper;

import com.sg.FoodDelivery.model.Restaurant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantMapper implements RowMapper<Restaurant> {
    @Override
    public Restaurant mapRow(ResultSet rs, int i) throws SQLException {
        return new Restaurant(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("address")
        );
    }
}
