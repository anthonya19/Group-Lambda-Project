package com.sg.FoodDelivery.dao;

import com.sg.FoodDelivery.model.Client;
import com.sg.FoodDelivery.model.MenuItem;
import com.sg.FoodDelivery.model.Order;
import com.sg.FoodDelivery.model.Rating;
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
    public Client addClient(Client client) {
        final String ADD_CLIENT = "INSERT INTO client(username, address, password) VALUES (?, ?, ?);";

        jdbc.update(ADD_CLIENT, client.getUsername(), client.getAddress(), client.getPassword());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        client.setId(newId);

        return client;
    }

    @Override
    @Transactional
    public Order placeOrder(Client client, Order order) {
        final String PLACE_ORDER = "INSERT INTO orders(total_price, client_id, restaurant_id) VALUES (?, ?, ?);";
        jdbc.update(PLACE_ORDER, this.orderCost(order), order.getClientId(), order.getRestaurantId());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        order.setOrderId(newId);

        final String ORDER_ITEMS = "INSERT INTO order_items(order_id, menu_item_id, quantity) VALUES (?, ? ,?);";
        List<MenuItem> orderItems = order.getOrderItems();
        //not sure how to handle the case where there are multiple of the same item
        for(MenuItem item : orderItems) {
            jdbc.update(ORDER_ITEMS, order.getOrderId(), item.getItemId(), 1);
        }

        return order;
    }

    /**
     * Helper method to calculate total cost of an order based off a list of order items
     * @param order
     * @return total
     */
    private double orderCost(Order order) {
        List<MenuItem> orderItems = order.getOrderItems();
        double total = 0;
        for(MenuItem item : orderItems) {
            total += item.getPrice();
        }
        order.setTotalPrice(total);
        return total;
    }

    @Override
    public boolean viewOrderStatus(Order order) {
        return false;
    }

    @Override
    public List<Order> viewOrders(Client client) {
        return null;
    }

    @Override
    public Rating rateDriver(Order order) {
        return null;
    }

    @Override
    public Rating rateRestaurant(Order order) {
        return null;
    }

    public static final class ClientMapper implements RowMapper<Client> {

        @Override
        public Client mapRow(ResultSet rs, int index) throws SQLException {
            Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setUsername(rs.getString("username"));
            client.setPassword(rs.getString("password"));
            client.setAddress(rs.getString("address"));
            return client;
        }
    }
}
