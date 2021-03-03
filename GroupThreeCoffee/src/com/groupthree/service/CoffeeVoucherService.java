package com.groupthree.service;

import com.groupthree.bean.CoffeeVoucher;
import com.groupthree.dao.CoffeeVoucherDao;
import com.groupthree.dao.CoffeeVoucherDaoInterface;

import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeVoucherService implements CoffeeVoucherServiceInterface{

        private CoffeeVoucherDaoInterface coffeeVoucherDao= new CoffeeVoucherDao();
        @Override
        public ArrayList<CoffeeVoucher> getCoffeeVoucher() throws ClassNotFoundException, SQLException {
            return coffeeVoucherDao.getCoffeeVoucher();

        }
}
