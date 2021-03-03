package com.groupthree.service;

import java.sql.SQLException;

public class CoffeeVoucherService implements CoffeeVoucherServiceInterface{

        private CoffeeVoucherDaoInterface coffeeVoucherDao= CoffeeVoucherDao();
        @Override
        public ArrayList<CoffeeVoucher> getCoffeeVoucher() throws ClassNotFoundException, SQLException {
            return coffeeVoucherDao.getCoffeeVoucher();

        }
}
