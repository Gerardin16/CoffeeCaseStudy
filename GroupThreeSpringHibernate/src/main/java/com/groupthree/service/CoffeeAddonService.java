package com.groupthree.service;

import com.groupthree.bean.CoffeeAddon;
import com.groupthree.dao.CoffeeAddonDao;
import com.groupthree.dao.CoffeeAddonDaoInterface;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CoffeeAddonService implements CoffeeAddonServiceInterface {
	@Autowired
    private CoffeeAddonDaoInterface coffeeAddonDao ;

    @Override
    public ArrayList<CoffeeAddon> getCoffeeAddon() {
        return coffeeAddonDao.getCoffeeAddon();

    }
}