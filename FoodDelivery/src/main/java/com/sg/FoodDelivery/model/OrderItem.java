package com.sg.FoodDelivery.model;

public class OrderItem extends MenuItem{

    private int order_id;
    private int quantity;

    /**
     * @param order_id
     * @param quantity
     */
    public OrderItem(int order_id, int quantity)
    {
        this.order_id = order_id;
        this.quantity = quantity;
    }

    /**
     * @param itemId
     * @param restaurantId
     * @param name
     * @param price
     * @param description
     * @param order_id
     * @param quantity
     */
    public OrderItem(int itemId, int restaurantId, String name, float price, String description, int order_id, int quantity)
    {
        super(itemId, restaurantId, name, price, description);
        this.order_id = order_id;
        this.quantity = quantity;
    }

    /**
     * @return the order_id
     */
    public int getOrder_id()
    {
        return order_id;
    }

    /**
     * @param order_id the order_id to set
     */
    public void setOrder_id(int order_id)
    {
        this.order_id = order_id;
    }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
}
