package com.groupthree.presentation;
import java.sql.SQLException;
public interface BeveragePresentationInterface {
    public void showBeveragesMenu() ;
    public void showCoffeeType() throws SQLException, ClassNotFoundException;
    public void showCoffeeSize() throws SQLException, ClassNotFoundException;
    public void showCoffeeAddon() throws SQLException, ClassNotFoundException;
    public void showVoucher() throws SQLException, ClassNotFoundException;
    public void printBill() throws SQLException, ClassNotFoundException;
    public void populateOrderNum() throws SQLException, ClassNotFoundException;
}
