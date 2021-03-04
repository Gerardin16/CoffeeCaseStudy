package com.groupthree.bean;

public class CoffeeBill {
		private int billId;
		private String orderNumber;
		private int voucherId;
		private double totalAmt;
		
		public CoffeeBill() {
			
		}

		public int getBillId() {
			return billId;
		}
		public void setBillId(int billId) {
			this.billId = billId;
		}
		public String getOrderNumber() {
			return orderNumber;
		}
		public void setOrderNumber(String orderNumber) {
			this.orderNumber = orderNumber;
		}
		public int getVoucherId() {
			return voucherId;
		}
		public void setVoucherId(int voucherId) {
			this.voucherId = voucherId;
		}
		public double getTotalAmt() {
			return totalAmt;
		}
		public void setTotalAmt(double totalNo) {
			this.totalAmt= totalNo;
		}
		@Override
		public String toString() {
			return "CoffeeBill [billId=" + billId + ", orderNumber=" + orderNumber + ", voucherId=" + voucherId
					+ ", totalNo=" + totalAmt + "]";
		}
}
