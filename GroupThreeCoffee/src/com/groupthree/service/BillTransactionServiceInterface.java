package com.groupthree.service;

import com.groupthree.bean.CoffeeBill;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BillTransactionServiceInterface {

    double GST_TAX=0.18;
    double SERVICE_TAX=0.18;
    public void createUpdateOrder()throws ClassNotFoundException, SQLException;
    public ArrayList<CoffeeBill> generateBill()throws ClassNotFoundException,SQLException;


}
