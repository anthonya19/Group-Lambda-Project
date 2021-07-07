package com.sg.FoodDelivery.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.sg.FoodDelivery.dao.row_mapper.Order_Items_Mapper;
import com.sg.FoodDelivery.dao.row_mapper.Orders_Mapper;
import com.sg.FoodDelivery.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public abstract class Parent_DAO
{
    protected final JdbcTemplate java_database_connection;

    @Autowired
    //may not work with abstract
    public Parent_DAO(JdbcTemplate java_database_connection)
    {
        this.java_database_connection = java_database_connection;
    }

    /**
     * Display all order fields excluding primary key.
     * 
     * @param FILTER represents which attribute is used
     * @param ID the value to use with FILTER
     * @return the {@link Order} values which correspond to the query
     */
    public List<Order> query_orders(final String FILTER, final String ID)
    {
        List<Order> to_return = this.java_database_connection.query("SELECT * FROM orders WHERE ? = ?;", new Orders_Mapper(), FILTER, ID);

        to_return.parallelStream().forEach(x -> this.join_order_items_with_menu_items(x));

        return to_return;
    }

    public void join_order_items_with_menu_items(final Order INPUT)
    {
        //would be better to apply WHERE before INNER JOIN by using w sub-queries.
        INPUT.setOrderItems(this.java_database_connection.query("SELECT * FROM order_items INNER JOIN menu_items ON order_items.menu_item_id = menu_items.id WHERE order_id = ?;",
                                                                new Order_Items_Mapper(), INPUT.getOrderId()));
    }
}
