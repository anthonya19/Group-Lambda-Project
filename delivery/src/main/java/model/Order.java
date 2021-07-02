package model;

import java.util.Date;
import java.util.List;

public class Order {

	private int orderID;
	private Date orderDate;
	private Driver driver;
	private Client client;
	private Restaurant restaurant;
	private List<Meal> meals;
	private float deliveryFees;
	private float total;
}
