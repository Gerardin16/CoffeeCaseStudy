package com.groupthree.dao;

import com.groupthree.bean.CoffeeType;
import com.groupthree.util.OracleConnectionManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeTypeDao implements CoffeeTypeDaoInterface {


    @Override
    public ArrayList<CoffeeType> getCoffeeType() throws ClassNotFoundException,SQLException {
        Connection connection = null;
        ArrayList<CoffeeType> coffeeTypes = new ArrayList<>();

        connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","wiley123");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM COFFEE_TYPE");

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            CoffeeType coffeeType = new CoffeeType();
            coffeeType.setCoffeeId(resultSet.getInt("COFFEE_ID"));
            coffeeType.setCoffeeName(resultSet.getString("COFFEE_NAME"));
            coffeeType.setCoffeeNamePrice(resultSet.getInt("COFFEE_NAME_PRICE"));

            coffeeTypes.add(coffeeType);
        }
        connection.close();
        return coffeeTypes;

    }



}

