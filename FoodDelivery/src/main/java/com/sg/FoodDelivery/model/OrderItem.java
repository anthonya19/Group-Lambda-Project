package com.sg.FoodDelivery.model;

public class OrderItem extends MenuItem{

    private int quantity;

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

    public double getPrice() {
        return super.getPrice();
    }

    public void setPrice(double price) {
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
}
