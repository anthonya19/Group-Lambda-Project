package com.sg.FoodDelivery.dao.row_mapper;

import com.sg.FoodDelivery.model.MenuItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuItemMapper implements RowMapper<MenuItem> {
    @Override
    public MenuItem mapRow(ResultSet rs, int i) throws SQLException {
        return new MenuItem(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getFloat("price"),
                rs.getString("description")
        );
    }
}
