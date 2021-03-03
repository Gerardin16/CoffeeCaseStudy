package com.groupthree.service;

import java.sql.SQLException;

public class CoffeeTypeService implements CoffeeTypeServiceInterface{
    private CoffeeTypeDaoInterface coffeeTypeDao= CoffeeTypeDao();

    @Override
    public ArrayList<CoffeeType> getCoffeeType() throws ClassNotFoundException, SQLException {
        return coffeeTypeDao.getCoffeeType();
    }
}
