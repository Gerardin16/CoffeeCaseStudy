package com.groupthree.service;

import java.sql.SQLException;

public interface CoffeeVoucherServiceInterface {

    ArrayList<CoffeeVoucher> getCoffeeVoucher()throws ClassNotFoundException, SQLException;
}
