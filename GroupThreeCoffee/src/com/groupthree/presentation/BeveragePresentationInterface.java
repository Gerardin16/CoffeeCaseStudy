package com.groupthree.presentation;
import java.sql.SQLException;
public interface BeveragePresentationInterface {
    public void showBeveragesMenu() throws ClassNotFoundException, SQLException;
    public void showCoffeeType() throws SQLException, ClassNotFoundException;
    public void showCoffeeSize() throws SQLException, ClassNotFoundException;
    public void showCoffeeAddon() throws SQLException, ClassNotFoundException;
    public void showVoucher() throws SQLException, ClassNotFoundException;
    public void printBill(String initialOrderNum, int selectedVoucher) throws SQLException, ClassNotFoundException;
    String ORDER_NUMBER="ORDR";
}
