package com.sg.FoodDelivery.dao;

import com.sg.FoodDelivery.model.Driver;
import com.sg.FoodDelivery.model.Order;
import com.sg.FoodDelivery.model.Rating;

import java.util.List;

public interface DriverDao {

    int addDriver(Driver driver);
    Driver getDriverByUsername(String username);
    List<Order> viewAvailableOrders();
    void acceptOrder(int driverId, int orderId);
    void rateClient(Rating rating);
    List<Rating> viewRatings(Driver driver);
    List<Order> viewCompletedOrders(int driverId);

}
