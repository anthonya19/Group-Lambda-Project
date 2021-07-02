package com.sg.FoodDelivery.dao;

import com.sg.FoodDelivery.model.MenuItem;
import com.sg.FoodDelivery.model.Order;
import com.sg.FoodDelivery.model.Restaurant;

import java.util.List;

public interface RestaurantDao {

    Restaurant addRestaurant(Restaurant restaurant);
    List<MenuItem> modifyMenu(Restaurant restaurant, List<MenuItem> menu);
    List<MenuItem> displayMenu(Restaurant restaurant);
    List<Order> displayOrders(Restaurant restaurant);

}
