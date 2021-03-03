package com.groupthree.service;

public interface BillTransactionServiceInterface {

    double GST_TAX=0.18;
    double SERVICE_TAX=0.18;
    public void createUpdateOrder();
    public void generateBill();
}
