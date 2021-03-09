package com.groupthree.bean;

public class CoffeeAddon {

	private int coffeeAddonId;
	private String coffeeAddonName;
	private int coffeeAddonPrice;
	
	public CoffeeAddon() {
		
	}

	public CoffeeAddon(int coffeeAddonId, String coffeeAddonName, int coffeeAddonPrice) {
		super();
		this.coffeeAddonId = coffeeAddonId;
		this.coffeeAddonName = coffeeAddonName;
		this.coffeeAddonPrice = coffeeAddonPrice;
	}

	public int getCoffeeAddonId() {
		return coffeeAddonId;
	}

	public void setCoffeeAddonId(int coffeeAddonId) {
		this.coffeeAddonId = coffeeAddonId;
	}

	public String getCoffeeAddonName() {
		return coffeeAddonName;
	}

	public void setCoffeeAddonName(String coffeeAddonName) {
		this.coffeeAddonName = coffeeAddonName;
	}

	public int getCoffeeAddonPrice() {
		return coffeeAddonPrice;
	}

	public void setCoffeeAddonPrice(int coffeeAddonPrice) {
		this.coffeeAddonPrice = coffeeAddonPrice;
	}

	@Override
	public String toString() {
		return "CoffeeAddon [coffeeAddonId=" + coffeeAddonId + ", coffeeAddonName=" + coffeeAddonName
				+ ", coffeeAddonPrice=" + coffeeAddonPrice + "]";
	}
	
	

}
