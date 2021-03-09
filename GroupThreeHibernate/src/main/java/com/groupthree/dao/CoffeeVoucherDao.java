package com.groupthree.dao;

import com.groupthree.bean.CoffeeType;
import com.groupthree.bean.CoffeeVoucher;
import com.groupthree.util.OracleConnectionManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeVoucherDao implements CoffeeVoucherDaoInterface{


    @Override
    public ArrayList<CoffeeVoucher> getCoffeeVoucher() throws ClassNotFoundException,SQLException {
        Connection connection = null;
        ArrayList<CoffeeVoucher> coffeeVouchers= new ArrayList<>();

        connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","wiley123");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM VOUCHER WHERE VOUCHER_CODE<>'DUMMY'");

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            CoffeeVoucher coffeeVoucher= new CoffeeVoucher();
            coffeeVoucher.setVoucherId(resultSet.getInt("VOUCHER_ID"));
            coffeeVoucher.setVoucherCode(resultSet.getString("VOUCHER_CODE"));
            coffeeVoucher.setVoucherDescription(resultSet.getString("VOUCHER_DESCRIPTION"));

            coffeeVouchers.add(coffeeVoucher);
        }
        connection.close();
        return coffeeVouchers;


    }
}
