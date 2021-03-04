package com.groupthree.util;

import com.groupthree.bean.CoffeeAddon;
import com.groupthree.bean.CoffeeBill;
import com.groupthree.bean.CoffeeSize;
import com.groupthree.bean.CoffeeType;

import java.util.Set;
import java.util.TreeMap;

public class BeverageHelper {

	public static void displayCoffeeType(CoffeeType ct){
		System.out.println(ct.getCoffeeName()+" - "+ ct.getCoffeeNamePrice());
	}
	public static void displayCoffeeSize(CoffeeSize cs) {
		System.out.println(cs.getCoffeeSizeName()+" - "+cs.getCoffeeSizePrice());
	}
	public static void displayCoffeeAddOn(CoffeeAddon ca) {
		System.out.println(ca.getCoffeeAddonName()+" - "+ca.getCoffeeAddonPrice());
	}

	public static void displayCoffeeBill(TreeMap<String, Double> bill) {

		System.out.println("==========================");
		System.out.println("Final Invoice");
		Set<String> keys = bill.keySet();
		for (String key : keys) {
			System.out.println(key+"-"+bill.get(key));
		}
	}
}

