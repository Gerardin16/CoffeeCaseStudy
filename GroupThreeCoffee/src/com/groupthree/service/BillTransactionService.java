package com.groupthree.service;

import com.groupthree.bean.CoffeeBill;

import java.sql.SQLException;
import java.util.ArrayList;

public class BillTransactionService implements BillTransactionServiceInterface{

    public String OrderNumber;



    @Override
    public ArrayList<CoffeeBill> generateBill() throws ClassNotFoundException, SQLException {
        return null;
    }
  

    @Override
    public void createCoffeeOrder() {

    }


}
