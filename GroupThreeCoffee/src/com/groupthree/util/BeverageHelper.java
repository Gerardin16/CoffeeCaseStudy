package com.groupthree.util;

import com.groupthree.bean.CoffeeAddon;
import com.groupthree.bean.CoffeeBill;
import com.groupthree.bean.CoffeeSize;
import com.groupthree.bean.CoffeeType;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class BeverageHelper {
	public static void displayPersonName(PersonDetails pt){
		System.out.println(pt.getPersonName());
	}

	public static void displayCoffeeType(CoffeeType ct){
		System.out.println(ct.getCoffeeName()+" - "+ ct.getCoffeeNamePrice());
	}
	public static void displayCoffeeSize(CoffeeSize cs) {
		System.out.println(cs.getCoffeeSizeName()+" - "+cs.getCoffeeSizePrice());
	}
	public static void displayCoffeeAddOn(CoffeeAddon ca) {
		System.out.println(ca.getCoffeeAddonName()+" - "+ca.getCoffeeAddonPrice());
	}

	public static void displayCoffeeBill(ArrayList bill) {

		System.out.println("==========================");
		System.out.println("Final Invoice");
//		for(int index=0;index< bill.size();index++){
//			System.out.println(bill.get(index));
//		}
		System.out.print("Total Value:");
		System.out.println(bill.get(0));
		System.out.print("Discount:");
		System.out.println(bill.get(1));
		System.out.print("Net Value:");
		System.out.println(bill.get(2));
		System.out.print("GST:");
		System.out.println(bill.get(3));
		System.out.print("Service Tax:");
		System.out.println(bill.get(4));
		System.out.print("Total Bill:");
		System.out.println(bill.get(5));
	}
}

