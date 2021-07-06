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

    /**
     * Function which maps a restaurant ID to its name.
     * 
     * @param ID to be matched
     * @return name of matched restaurant
     */
    public String ID_map_name(final int ID)
    {
        return super.java_database_connection.queryForObject("SELECT name FROM restaurant WHERE id = ?;", String.class, ID);
    }

    /*Restaurant addRestaurant(Restaurant restaurant);
    List<MenuItem> add_menu(Restaurant restaurant, List<MenuItem> menu);
    List<MenuItem> displayMenu(Restaurant restaurant);*/
    public List<Order> display_orders(final Restaurant INPUT)
    {
        return super.query_orders("restaurant_id", String.valueOf(INPUT.getId()));
    }
}
