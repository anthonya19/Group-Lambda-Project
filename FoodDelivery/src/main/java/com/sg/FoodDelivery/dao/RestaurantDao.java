package com.sg.FoodDelivery.dao;

import java.util.List;

import com.sg.FoodDelivery.dao.row_mapper.MenuItemMapper;
import com.sg.FoodDelivery.dao.row_mapper.Order_Items_Mapper;
import com.sg.FoodDelivery.dao.row_mapper.Orders_Mapper;
import com.sg.FoodDelivery.dao.row_mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.sg.FoodDelivery.model.Order;
import com.sg.FoodDelivery.model.Restaurant;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDao
{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RestaurantDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Function which maps a restaurant ID to its name.
     * 
     * @param ID to be matched
     * @return name of matched restaurant
     *//*
    public String ID_map_name(final int ID)
    {
        return super.java_database_connection.queryForObject("SELECT name FROM restaurant WHERE id = ?;", String.class, ID);
    }

    *//*Restaurant addRestaurant(Restaurant restaurant);
    List<MenuItem> add_menu(Restaurant restaurant, List<MenuItem> menu);
    List<MenuItem> displayMenu(Restaurant restaurant);*//*
    public List<Order> display_orders(final Restaurant INPUT)
    {
        return super.query_orders("restaurant_id", String.valueOf(INPUT.getId()));
    }*/

    public List<Restaurant> getRestaurants(){
        List<Restaurant> restaurants;

        String sql = "SELECT * FROM restaurant;";
        restaurants = jdbcTemplate.query(sql, new RestaurantMapper());

        sql = "select menu_items.id, price, menu_items.name, description from restaurant inner join menu_items on menu_items.restaurant_id = restaurant.id where restaurant_id = ?;";

        for(Restaurant restaurant : restaurants){
            restaurant.setMenuItems(jdbcTemplate.query(sql, new MenuItemMapper(), restaurant.getId()));
        }

        return restaurants;
    }

}
