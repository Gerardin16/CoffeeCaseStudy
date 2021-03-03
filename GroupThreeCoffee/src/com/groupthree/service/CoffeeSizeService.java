package com.groupthree.service;

import java.sql.SQLException;

public class CoffeeSizeService implements CoffeeSizeServiceInterface{

    private CoffeeSizeDaoInterface coffeeSizeDao= CoffeeSizeDao();
    @Override
    public ArrayList<CoffeeSize> getCoffeeSize() throws ClassNotFoundException, SQLException {
        return coffeeSizeDao.getCoffeeSize();

    }
}
