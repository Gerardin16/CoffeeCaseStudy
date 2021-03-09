package com.groupthree.service;

import com.groupthree.bean.CoffeeSize;
import com.groupthree.dao.CoffeeSizeDao;
import com.groupthree.dao.CoffeeSizeDaoInterface;

import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeSizeService implements CoffeeSizeServiceInterface{

    private CoffeeSizeDaoInterface coffeeSizeDao= new CoffeeSizeDao();
    @Override
    public ArrayList<CoffeeSize> getCoffeeSize() throws ClassNotFoundException, SQLException {
        return coffeeSizeDao.getCoffeeSize();

    }
}
