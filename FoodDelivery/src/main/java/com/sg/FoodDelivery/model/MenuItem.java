package com.sg.FoodDelivery.model;

public class MenuItem {

    public int itemId;
    public int restaurantId;
    public String name;
    public float price;
    public String description;

    public MenuItem()
    {

    }

    /**
     * @param itemId
     * @param restaurantId
     * @param name
     * @param price
     * @param description
     */
    public MenuItem(int itemId, int restaurantId, String name, float price, String description)
    {
        this.itemId = itemId;
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public MenuItem(int itemId, String name, float price, String description)
    {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
