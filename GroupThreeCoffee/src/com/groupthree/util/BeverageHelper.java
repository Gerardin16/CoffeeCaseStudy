package com.groupthree.util;

import com.groupthree.bean.CoffeeAddon;
import com.groupthree.bean.CoffeeBill;
import com.groupthree.bean.CoffeeSize;
import com.groupthree.bean.CoffeeType;

public class BeverageHelper {

	public static void displayCoffeeType(CoffeeType ct){
		System.out.println(ct.getCoffeeName());
	}
	public static void displayCoffeeSize(CoffeeSize cs) {
		System.out.println(cs.getCoffeeSizeName());
	}
	public static void displayCoffeeAddOn(CoffeeAddon ca) {
		System.out.println(ca.getCoffeeAddonName());
	}
	public static void displayCoffeeBill(CoffeeBill cb) {
	System.out.println(cb.getBillId()+" "+cb.getOrderNumber()+" "+cb.getVoucherId()+" "+cb.getTotalNo());
}


}
