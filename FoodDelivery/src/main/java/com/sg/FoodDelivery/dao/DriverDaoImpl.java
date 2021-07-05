package com.sg.FoodDelivery.dao;

import com.sg.FoodDelivery.model.Driver;
import com.sg.FoodDelivery.model.Order;
import com.sg.FoodDelivery.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.*;
import java.util.List;

@Repository
public class DriverDaoImpl implements DriverDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DriverDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public int addDriver(Driver driver) {
        String sql = "INSERT INTO driver(username, password) VALUES (?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) ->{
            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, driver.getUsername());
            statement.setString(2, driver.getPassword());
            return statement;
        }, keyHolder);


        return keyHolder.getKey().intValue();
    }

    @Override
    public Driver getDriverByUsername(String username) {
        String sql = "SELECT * FROM driver WHERE username = ?;";
        return jdbcTemplate.queryForObject(sql, new DriverMapper(), username);
    }

    @Override
    public List<Order> viewAvailableOrders() {
        return null;
    }

    @Override
    public void acceptOrder(Order order) {

    }

    @Override
    public Rating rateClient(Order order) {
        return null;
    }

    @Override
    public List<Order> viewCompletedOrders(Driver driver) {
        return null;
    }

    private class DriverMapper implements RowMapper<Driver> {
        @Override
        public Driver mapRow(ResultSet rs, int i) throws SQLException {
            return new Driver(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password")
            );
        }
    }
}
