package com.sg.FoodDelivery.model;

public class OrderItem extends MenuItem{

    private int orderId;
    private int quantity;


    public OrderItem(int itemId, int restaurantId, String name, float price, String description, int orderId, int quantity) {
        super(itemId, restaurantId, name, price, description);
        this.orderId = orderId;
        this.quantity = quantity;
    }


    public int getItemId() {
        return super.getItemId();
    }

    public void setItemId(int itemId) {
        super.setItemId(itemId);
    }

    public int getRestaurantId() { return super.getRestaurantId(); }

    public void setRestaurantId(int restaurantId) {
        super.setRestaurantId(restaurantId);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) { super.setName(name); }

    public float getPrice() {
        return super.getPrice();
    }

    public void setPrice(float price) {
        super.setPrice(price);
    }

    public String getDescription() {
        return super.getDescription();
    }

    public void setDescription(String description) {
        super.setDescription(description);
    }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
