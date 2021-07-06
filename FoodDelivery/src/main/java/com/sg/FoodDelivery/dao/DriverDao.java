package com.sg.FoodDelivery.dao;

import com.sg.FoodDelivery.model.Driver;
import com.sg.FoodDelivery.model.Order;
import com.sg.FoodDelivery.model.Rating;

import java.util.List;

public interface DriverDao {

    Driver addDriver(Driver driver);
    List<Order> viewAvailableOrders();
    void acceptOrder(Order order);
    Rating rateClient(Order order);
    List<Order> viewCompletedOrders(Driver driver);

}
