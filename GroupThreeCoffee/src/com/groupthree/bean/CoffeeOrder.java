package com.groupthree.bean;

public class CoffeeOrder {
		private int orderId;
		private String orderNumber;
	private int coffeeId;
	private int coffeeSizeId;
	private int coffeeAddonId;
	private int personId;

	public int getPersonId() {
		return personId;
	}


	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public CoffeeOrder() {

	}


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getCoffeeId() {
		return coffeeId;
	}

	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}

	public int getCoffeeSizeId() {
		return coffeeSizeId;
	}

	public void setCoffeeSizeId(int coffeeSizeId) {
		this.coffeeSizeId = coffeeSizeId;
	}

	public int getCoffeeAddonId() {
		return coffeeAddonId;
	}

	public void setCoffeeAddonId(int coffeeAddonId) {
		this.coffeeAddonId = coffeeAddonId;
	}

	public CoffeeOrder(int orderId, String orderNumber, int coffeeId, int coffeeSizeId, int coffeeAddonId) {
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.coffeeId = coffeeId;
		this.coffeeSizeId = coffeeSizeId;
		this.coffeeAddonId = coffeeAddonId;
	}
}
