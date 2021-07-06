package com.sg.FoodDelivery.dao.row_mapper;

import com.sg.FoodDelivery.model.Driver;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Driver_Mapper implements RowMapper<Driver> {
    @Override
    public Driver mapRow(ResultSet rs, int i) throws SQLException {
        return new Driver(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password")
        );
    }
}