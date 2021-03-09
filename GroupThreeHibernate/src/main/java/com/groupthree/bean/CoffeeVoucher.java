package com.groupthree.bean;

public class CoffeeVoucher {
	private int voucherId;
	private String voucherCode;
	private String voucherDescription;
	
	public CoffeeVoucher() {
		
	}

	public CoffeeVoucher(int voucherId, String voucherCode, String voucherDescription) {
		super();
		this.voucherId = voucherId;
		this.voucherCode = voucherCode;
		this.voucherDescription = voucherDescription;
	}

	public int getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public String getVoucherDescription() {
		return voucherDescription;
	}

	public void setVoucherDescription(String voucherDescription) {
		this.voucherDescription = voucherDescription;
	}

	@Override
	public String toString() {
		return "Voucher [voucherId=" + voucherId + ", voucherCode=" + voucherCode + ", voucherDescription="
				+ voucherDescription + "]";
	}
	
	
	
}
