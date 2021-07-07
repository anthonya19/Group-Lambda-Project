package com.sg.FoodDelivery.dao;

import com.sg.FoodDelivery.dao.row_mapper.Driver_Mapper;
import com.sg.FoodDelivery.dao.row_mapper.Order_Items_Mapper;
import com.sg.FoodDelivery.dao.row_mapper.Orders_Mapper;
import com.sg.FoodDelivery.dao.row_mapper.Rating_Mapper;
import com.sg.FoodDelivery.model.Driver;
import com.sg.FoodDelivery.model.Order;
import com.sg.FoodDelivery.model.OrderItem;
import com.sg.FoodDelivery.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
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
        return jdbcTemplate.queryForObject(sql, new Driver_Mapper(), username);
    }

    @Override
    public List<Order> viewAvailableOrders() {
        List<Order> orders;

        String sql = "SELECT * FROM orders WHERE is_delivered = false;";
        orders = jdbcTemplate.query(sql, new Orders_Mapper());

        sql = "select order_id, menu_item_id, restaurant_id, quantity, price, name, description from order_items" +
                " inner join menu_items on order_items.menu_item_id = menu_items.id"
                +" where order_id = ?;";

        for(Order order : orders){
            order.setOrderItems(jdbcTemplate.query(sql, new Order_Items_Mapper(), order.getOrderId()));
        }

        return orders;
    }


    @Override
    public void acceptOrder(int driverId ,int orderId) {
        String sql = "update orders SET is_delivered = true, driver_id = ? where id = ?;";
        jdbcTemplate.update(sql, driverId, orderId);
    }

    @Override
    public void rateClient(Rating rating) {
        String sql = "INSERT INTO client_rating(rating, client_id, description) VALUES (?, ?, ?);";
        jdbcTemplate.update(sql, rating.getRating(), rating.getUserId(), rating.getDescription());
    }

    @Override
    public List<Rating> viewRatings(int driverId) {
        String sql = "SELECT * FROM driver_rating WHERE driver_id = ?;";
        return jdbcTemplate.query(sql, new Rating_Mapper(), driverId);
    }

    @Override
    public List<Order> viewCompletedOrders(int driverId) {

        List<Order> orders;
        String sql = "SELECT * FROM orders WHERE driver_id = ?;";
        orders = jdbcTemplate.query(sql, new Orders_Mapper(), driverId);

        sql = "select order_id, menu_item_id, restaurant_id, quantity, price, name, description from order_items" +
                " inner join menu_items on order_items.menu_item_id = menu_items.id"
                +" where order_id = ?;";

        for(Order order : orders){
            order.setOrderItems(jdbcTemplate.query(sql, new Order_Items_Mapper(), order.getOrderId()));
        }

        return orders;
    }

}
