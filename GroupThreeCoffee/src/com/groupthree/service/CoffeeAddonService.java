package com.groupthree.service;

import java.sql.SQLException;

public class CoffeeAddonService implements CoffeeAddonServiceInterface {

    private CoffeeAddonDaoInterface coffeeAddonDao = CoffeeAddonDao();

    @Override
    public ArrayList<CoffeeAddon> getCoffeeAddon() throws ClassNotFoundException, SQLException {
        return coffeeAddonDao.getCoffeeAddon();

    }
}