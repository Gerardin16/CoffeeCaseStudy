package com.groupthree.service;

import com.groupthree.bean.CoffeeType;
import com.groupthree.dao.CoffeeTypeDao;
import com.groupthree.dao.CoffeeTypeDaoInterface;

import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeTypeService implements CoffeeTypeServiceInterface{
    private CoffeeTypeDaoInterface coffeeTypeDao=new CoffeeTypeDao();

    @Override
    public ArrayList<CoffeeType> getCoffeeType()  {
        return coffeeTypeDao.getCoffeeType();
    }

}
