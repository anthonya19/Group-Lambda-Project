package com.sg.FoodDelivery.dao;

import com.sg.FoodDelivery.model.*;

import java.util.List;

public interface ClientDao {

    /** Create new client */
    Client addClient(Client client);
    /** Client places a new order */
    Order placeOrder(Client client, Order order);
    /** Client views the status of one of their orders */
    boolean viewOrderStatus(Order order);
    /** Client views all of their orders */
    List<Order> viewOrders(Client client);
    /** Client rates the driver from a given order */
    Rating rateDriver(Order order);
    /** Client rates the restaurant from a given order */
    Rating rateRestaurant(Order order);

}
