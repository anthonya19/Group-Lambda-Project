package com.sg.FoodDelivery.dao.row_mapper;

import com.sg.FoodDelivery.model.Rating;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Rating_Mapper implements RowMapper<Rating> {

    @Override
    public Rating mapRow(ResultSet rs, int index) throws SQLException {
        return new Rating(rs.getInt("id"),
                rs.getInt("rating"),
                rs.getInt("client_id"),
                rs.getString("description"));
    }
}