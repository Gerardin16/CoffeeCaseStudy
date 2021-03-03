package com.groupthree.service;

import com.groupthree.bean.CoffeeAddon;
import com.groupthree.dao.CoffeeAddonDao;
import com.groupthree.dao.CoffeeAddonDaoInterface;

import java.util.ArrayList;

public class CoffeeAddonService implements CoffeeAddonServiceInterface {

    private CoffeeAddonDaoInterface coffeeAddonDao = new CoffeeAddonDao();

    @Override
    public ArrayList<CoffeeAddon> getCoffeeAddon()  {
        return coffeeAddonDao.getCoffeeAddon();

    }
}