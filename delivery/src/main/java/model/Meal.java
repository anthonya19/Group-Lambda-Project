package model;

public class Meal {
	
	private int mealID;
	private String mealName;
	private float price;
	public int getMealID() {
		return mealID;
	}
	public void setMealID(int mealID) {
		this.mealID = mealID;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public String getMealDescription() {
		return mealDescription;
	}
	public void setMealDescription(String mealDescription) {
		this.mealDescription = mealDescription;
	}
	public boolean isTrio() {
		return isTrio;
	}
	public void setTrio(boolean isTrio) {
		this.isTrio = isTrio;
	}
	public String getDrink() {
		return Drink;
	}
	public void setDrink(String drink) {
		Drink = drink;
	}
	private String mealDescription;
	private boolean isTrio;
	private String Drink;
	private enum Extra {
		  Fries,
		  Salad,
		  other
		}
}
