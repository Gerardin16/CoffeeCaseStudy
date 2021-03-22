package com.groupthree.service;

import com.groupthree.bean.CoffeeSize;
import com.groupthree.dao.CoffeeSizeDao;
import com.groupthree.dao.CoffeeSizeDaoInterface;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CoffeeSizeService implements CoffeeSizeServiceInterface{
	@Autowired
    private CoffeeSizeDaoInterface coffeeSizeDao;
    @Override
    public ArrayList<CoffeeSize> getCoffeeSize() {
        return coffeeSizeDao.getCoffeeSize();

    }
}
