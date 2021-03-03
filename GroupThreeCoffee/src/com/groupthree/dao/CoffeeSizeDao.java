package com.groupthree.dao;

import com.groupthree.bean.CoffeeSize;
import com.groupthree.bean.CoffeeType;
import com.groupthree.util.OracleConnectionManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeSizeDao implements CoffeeSizeDaoInterface {


    @Override
    public ArrayList<CoffeeSize> getCoffeeSize() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        ArrayList<CoffeeSize> coffeeSizes = new ArrayList<>();

        connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wiley123");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM COFFEE_SIZE");

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            CoffeeSize coffeeSize = new CoffeeSize();
            coffeeSize.setCoffeeSizeId(resultSet.getInt("COFFEE_SIZE_ID"));
            coffeeSize.setCoffeeSizeName(resultSet.getString("COFFEE_SIZE"));
            coffeeSize.setCoffeeSizePrice(resultSet.getInt("COFFEE_SIZE_PRICE"));

            coffeeSizes.add(coffeeSize);
        }
        connection.close();
        return coffeeSizes;

    }
}




