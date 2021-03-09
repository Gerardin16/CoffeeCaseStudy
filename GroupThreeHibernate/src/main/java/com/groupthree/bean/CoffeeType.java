package com.groupthree.bean;

public class CoffeeType {

	private int coffeeId;
	private String coffeeName;
	private int coffeeNamePrice;
	
	public CoffeeType() {
	
	}

	public CoffeeType(int coffeeId, String coffeeName, int coffeeNamePrice) {
		super();
		this.coffeeId = coffeeId;
		this.coffeeName = coffeeName;
		this.coffeeNamePrice = coffeeNamePrice;
	}




	public int getCoffeeId() {
		return coffeeId;
	}

	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public int getCoffeeNamePrice() {
		return coffeeNamePrice;
	}

	public void setCoffeeNamePrice(int coffeeNamePrice) {
		this.coffeeNamePrice = coffeeNamePrice;
	}

	@Override
	public String toString() {
		return "CoffeeType [coffeeId=" + coffeeId + ", coffeeName=" + coffeeName + ", coffeeNamePrice="
				+ coffeeNamePrice + "]";
	}
	
	
	
	
	
}
