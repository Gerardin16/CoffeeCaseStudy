package com.groupthree.presentation;
import java.sql.SQLException;
public interface BeveragePresentationInterface {
	
	
	  String ORDER_NUMBER="ORDR";
	  
    public int showPersonDetails() throws ClassNotFoundException, SQLException;
    public void showCoffeeType() throws SQLException, ClassNotFoundException;
    public void showCoffeeSize() throws SQLException, ClassNotFoundException;
    public void showCoffeeAddon() throws SQLException, ClassNotFoundException;
    public void showVoucher() throws SQLException, ClassNotFoundException;
    public void printBill(int Person,String initialOrderNum, int selectedVoucher) throws SQLException, ClassNotFoundException;
	public void showBeveragesMenu(int selectedPerson)throws ClassNotFoundException, SQLException;
	
}
