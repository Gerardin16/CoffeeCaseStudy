package com.groupthree.dao;
import java.sql.SQLException;
import java.util.ArrayList;

import com.groupthree.bean.CoffeeOrder;



public interface BillTransactionDaoInterface {


    public void createOrder(String orderNum, int selectedCoffeeType, int selectedCoffeeSize, int selectedAddon) throws ClassNotFoundException, SQLException;

	public ArrayList<Integer> getOrders(String initialOrderNum) throws SQLException, ClassNotFoundException;

    void createBill(String initialOrderNum, int selectedVoucher, double totalBill) throws SQLException, ClassNotFoundException;
}
