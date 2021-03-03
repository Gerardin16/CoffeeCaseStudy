package com.groupthree.bean;

public class CoffeeSize {
		private int coffeeSizeId;
		private String coffeeSizeName;
		private int coffeeSizePrice;
		
		public CoffeeSize() {
		
		}

		public CoffeeSize(int coffeeSizeId, String coffeeSizeName, int coffeeSizePrice) {
			super();
			this.coffeeSizeId = coffeeSizeId;
			this.coffeeSizeName = coffeeSizeName;
			this.coffeeSizePrice = coffeeSizePrice;
		}

		public int getCoffeeSizeId() {
			return coffeeSizeId;
		}

		public void setCoffeeSizeId(int coffeeSizeId) {
			this.coffeeSizeId = coffeeSizeId;
		}

		public String getCoffeeSizeName() {
			return coffeeSizeName;
		}

		public void setCoffeeSizeName(String coffeeSizeName) {
			this.coffeeSizeName = coffeeSizeName;
		}

		public int getCoffeeSizePrice() {
			return coffeeSizePrice;
		}

		public void setCoffeeSizePrice(int coffeeSizePrice) {
			this.coffeeSizePrice = coffeeSizePrice;
		}

		@Override
		public String toString() {
			return "CoffeeSize [coffeeSizeId=" + coffeeSizeId + ", coffeeSizeName=" + coffeeSizeName
					+ ", coffeeSizePrice=" + coffeeSizePrice + "]";
		}
		
		
		
		
}
