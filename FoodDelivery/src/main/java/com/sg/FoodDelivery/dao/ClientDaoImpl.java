package com.sg.FoodDelivery.dao;

import com.sg.FoodDelivery.dao.row_mapper.*;
import com.sg.FoodDelivery.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
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
    public Client getClientByUsername(String username) {
        String sql = "SELECT * FROM client WHERE username = ?;";
        return jdbc.queryForObject(sql, new Client_Mapper(), username);
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
    public List<OrderItem> viewOrderItems(int orderId) {
        final String ORDER_ITEMS = "select order_id, menu_item_id, restaurant_id, quantity, price, name, description from order_items" +
                " inner join menu_items on order_items.menu_item_id = menu_items.id"
                +" where order_id = ?;";
        return jdbc.query(ORDER_ITEMS, new Order_Items_Mapper(), orderId);
    }

    @Override
    public List<Order> viewOrders(int clientId) {
        List<Order> orders;

        String sql = "SELECT * FROM orders WHERE client_id = ?;";
        orders = jdbc.query(sql, new Orders_Mapper(), clientId);

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
    public List<Rating> viewRatings(int clientId) {
        final String VIEW_RATINGS = "SELECT * FROM client_rating WHERE client_id = ?;";
        return jdbc.query(VIEW_RATINGS, new Rating_Mapper(), clientId);
    }

    @Override
    public List<OrderDisplay> getOrderDisplay(int clientId) {
        List<OrderDisplay> orders;

        String sql = "Select orders.id, client.username, client.address as client_address, restaurant.name, restaurant.address as restaurant_address, total_price from" +
                " orders inner join client on orders.client_id = client.id" +
                " inner join restaurant on orders.restaurant_id = restaurant.id" +
                " where client_id = ?;";


        orders = jdbc.query(sql, new OrderDisplayMapper(), clientId);

        return orders;
    }
}
