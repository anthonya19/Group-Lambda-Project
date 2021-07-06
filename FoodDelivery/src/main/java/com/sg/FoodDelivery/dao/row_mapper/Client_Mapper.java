package com.sg.FoodDelivery.dao.row_mapper;

import com.sg.FoodDelivery.model.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Client_Mapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int index) throws SQLException {
        return new Client(rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("address"));
    }
}
