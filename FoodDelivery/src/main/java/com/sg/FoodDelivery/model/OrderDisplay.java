package com.sg.FoodDelivery.model;

public class OrderDisplay {
    public int orderId;
    public String clientName;
    public String clientAddress;
    public String restaurantName;
    public String restaurantAddress;
    public float totalPrice;

    public OrderDisplay(int orderId, String clientName, String clientAddress, String restaurantName, String restaurantAddress, float totalPrice) {
        this.orderId = orderId;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.totalPrice = totalPrice;
    }
}
