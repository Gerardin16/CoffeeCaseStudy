package com.groupthree.bean;

public class CoffeeBill {
		private int billId;
		private int orderNumber;
		private int voucherId;
		private float totalNo;
		
		public CoffeeBill() {
			
		}
		public CoffeeBill(int billId, int orderNumber, int voucherId, float totalNo) {
			super();
			this.billId = billId;
			this.orderNumber = orderNumber;
			this.voucherId = voucherId;
			this.totalNo = totalNo;
		}
		public int getBillId() {
			return billId;
		}
		public void setBillId(int billId) {
			this.billId = billId;
		}
		public int getOrderNumber() {
			return orderNumber;
		}
		public void setOrderNumber(int orderNumber) {
			this.orderNumber = orderNumber;
		}
		public int getVoucherId() {
			return voucherId;
		}
		public void setVoucherId(int voucherId) {
			this.voucherId = voucherId;
		}
		public float getTotalNo() {
			return totalNo;
		}
		public void setTotalNo(float totalNo) {
			this.totalNo = totalNo;
		}
		@Override
		public String toString() {
			return "CoffeeBill [billId=" + billId + ", orderNumber=" + orderNumber + ", voucherId=" + voucherId
					+ ", totalNo=" + totalNo + "]";
		}
}
