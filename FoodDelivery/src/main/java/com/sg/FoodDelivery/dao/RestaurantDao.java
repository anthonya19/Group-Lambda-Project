package com.sg.FoodDelivery.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.sg.FoodDelivery.model.Order;
import com.sg.FoodDelivery.model.Restaurant;

public class RestaurantDao extends Parent_DAO
{

    public RestaurantDao(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate);
    }

    /*Restaurant addRestaurant(Restaurant restaurant);
    List<MenuItem> add_menu(Restaurant restaurant, List<MenuItem> menu);
    List<MenuItem> displayMenu(Restaurant restaurant);*/
    List<Order> display_orders(final Restaurant INPUT)
    {
        return super.query_orders("restaurant_id", String.valueOf(INPUT.getId()));
    }
}
