package com.groupthree.service;

import com.groupthree.bean.CoffeeBill;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public interface BillTransactionServiceInterface {

    double GST_TAX=0.18;
    double SERVICE_TAX=0.18;


    public ArrayList generateBill(String initialOrderNum, int selectedVoucher)throws ClassNotFoundException,SQLException;

    public String createRandomOrderNumber();

    void createCoffeeOrder(String orderNum, int selectedCoffeeType, int selectedCoffeeSize, int selectedAddon) throws SQLException, ClassNotFoundException;

    String generateOrderNumber(String initialOrderNum, String c, int count);
}
