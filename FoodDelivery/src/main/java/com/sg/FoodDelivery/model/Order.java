package com.sg.FoodDelivery.model;

import java.sql.Date;
import java.util.List;

public class Order {

    private int orderId;
    private int clientId;
    private int driverId;
    private int restaurantId;
    private boolean isDelivered;
    private Date date;
    private List<OrderItem> orderItems;
    private float totalPrice;

    public Order()
    {

    }

    /**
     * @param orderId
     * @param clientId
     * @param driverId
     * @param restaurantId
     * @param isDelivered
     * @param date
     * @param totalPrice
     */
    public Order(int orderId, int clientId, int driverId, int restaurantId, boolean isDelivered, Date date, float totalPrice)
    {
        this.orderId = orderId;
        this.clientId = clientId;
        this.driverId = driverId;
        this.restaurantId = restaurantId;
        this.isDelivered = isDelivered;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice)
    {
        this.totalPrice = totalPrice;
    }
}
