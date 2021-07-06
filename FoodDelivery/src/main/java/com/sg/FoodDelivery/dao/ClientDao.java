package com.sg.FoodDelivery.dao;

import com.sg.FoodDelivery.model.*;

import java.util.List;

public interface ClientDao {

    /** Create new client */
    int addClient(Client client);
    /** Client places a new order */
    Order placeOrder(Order order);
    /** Client views the status of one of their orders */
    void viewOrderDetails(Order order);
    /** Client views all of their orders */
    List<Order> viewOrders(Client client);
    /** Client rates the driver from a given order */
    void rateDriver(Rating rating);
    /** Client rates the restaurant from a given order */
    void rateRestaurant(Rating rating);
    /** Client views their ratings */
    List<Rating> viewRatings(Client client);

}
