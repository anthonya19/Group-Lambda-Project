package com.sg.FoodDelivery.dao;

import com.sg.FoodDelivery.model.*;

import java.util.List;

public interface ClientDao {

    /** Create new client */
    int addClient(Client client);
    /** Retrieve a client based on username */
    Client getClientByUsername(String username);
    /** Client places a new order */
    Order placeOrder(Order order);
    /** Client views the status of one of their orders */
    List<OrderItem> viewOrderItems(int orderId);
    /** Client views all of their orders */
    List<Order> viewOrders(int clientId);
    /** Client rates the driver from a given order */
    void rateDriver(Rating rating);
    /** Client rates the restaurant from a given order */
    void rateRestaurant(Rating rating);
    /** Client views their ratings */
    List<Rating> viewRatings(int clientId);
    List<OrderDisplay> getOrderDisplay(int clientId);

}
