package com.sg.FoodDelivery.dao;

import com.sg.FoodDelivery.model.Driver;
import com.sg.FoodDelivery.model.Order;
import com.sg.FoodDelivery.model.OrderDisplay;
import com.sg.FoodDelivery.model.Rating;

import java.util.List;

public interface DriverDao {

    int addDriver(Driver driver);
    Driver getDriverByUsername(String username);
    List<Order> viewAvailableOrders();
    void acceptOrder(int driverId, int orderId);
    void rateClient(Rating rating);
    List<Rating> viewRatings(int driverId);
    List<Order> viewCompletedOrders(int driverId);
    List<OrderDisplay> getAvailableOrderDisplay();
    List<OrderDisplay> getPastOrders(int driverId);

}
