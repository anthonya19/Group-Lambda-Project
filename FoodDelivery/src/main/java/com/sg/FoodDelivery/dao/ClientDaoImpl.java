package com.sg.FoodDelivery.dao;

import com.sg.FoodDelivery.dao.row_mapper.Order_Items_Mapper;
import com.sg.FoodDelivery.dao.row_mapper.Orders_Mapper;
import com.sg.FoodDelivery.dao.row_mapper.Rating_Mapper;
import com.sg.FoodDelivery.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientDaoImpl implements ClientDao{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    @Transactional
    public int addClient(Client client) {
        final String ADD_CLIENT = "INSERT INTO client(username, address, password) VALUES (?, ?, ?);";

        jdbc.update(ADD_CLIENT, client.getUsername(), client.getAddress(), client.getPassword());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        client.setId(newId);

        return client.getId();
    }

    @Override
    @Transactional
    public Order placeOrder(Order order) {
        final String PLACE_ORDER = "INSERT INTO orders(total_price, client_id, restaurant_id) VALUES (?, ?, ?);";
        jdbc.update(PLACE_ORDER, this.orderCost(order), order.getClientId(), order.getRestaurantId());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        order.setOrderId(newId);

        final String ORDER_ITEMS = "INSERT INTO order_items(order_id, menu_item_id, quantity) VALUES (?, ? ,?);";
        List<OrderItem> orderItems = order.getOrderItems();

        for(OrderItem item : orderItems) {
            jdbc.update(ORDER_ITEMS, order.getOrderId(), item.getItemId(), item.getQuantity());
        }

        return order;
    }

    /**
     * Helper method to calculate total cost of an order based off a list of order items
     * @param order
     * @return total
     */
    private float orderCost(Order order) {
        List<OrderItem> orderItems = order.getOrderItems();
        float total = 0;
        for(MenuItem item : orderItems) {
            total += item.getPrice();
        }
        order.setTotalPrice(total);
        return total;
    }

    @Override
    public void viewOrderDetails(Order order) {
        final String ORDER_STATUS = "SELECT * FROM orders WHERE id = ?;";
        jdbc.queryForObject(ORDER_STATUS, new Orders_Mapper(), order.getOrderId());
    }

    @Override
    public List<Order> viewOrders(Client client) {
        List<Order> orders;

        String sql = "SELECT * FROM orders WHERE client_id = ?;";
        orders = jdbc.query(sql, new Orders_Mapper(), client.getId());

        sql = "select order_id, menu_item_id, restaurant_id, quantity, price, name, description from order_items" +
                " inner join menu_items on order_items.menu_item_id = menu_items.id"
                +" where order_id = ?;";

        for(Order order : orders){
            order.setOrderItems(jdbc.query(sql, new Order_Items_Mapper(), order.getOrderId()));
        }

        return orders;
    }

    @Override
    public void rateDriver(Rating rating) {
        final String RATE_DRIVER = "INSERT INTO driver_rating(rating, driver_id, description) VALUES (?, ?, ?);";
        jdbc.update(RATE_DRIVER, rating.getRating(), rating.getUserId(), rating.getDescription());
    }

    @Override
    public void rateRestaurant(Rating rating) {
        final String RATE_RESTAURANT = "INSERT INTO restaurant_rating(rating, driver_id, description) VALUES (?, ?, ?);";
        jdbc.update(RATE_RESTAURANT, rating.getRating(), rating.getUserId(), rating.getDescription());
    }

    @Override
    public List<Rating> viewRatings(Client client) {
        final String VIEW_RATINGS = "SELECT * FROM client_rating WHERE client_id = ?;";
        return jdbc.query(VIEW_RATINGS, new Rating_Mapper(), client.getId());
    }
}
