package com.groupthree.presentation;
import java.sql.SQLException;
public interface BeveragePresentationInterface {
	
	
	  String ORDER_NUMBER="ORDR";
	  
    public int showPersonDetails() ;
    public void showCoffeeType() ;
    public void showCoffeeSize();
    public void showCoffeeAddon() ;
    public void showVoucher() ;
    public void printBill(int Person,String initialOrderNum, int selectedVoucher);
	public void showBeveragesMenu(int selectedPerson);
	
}
