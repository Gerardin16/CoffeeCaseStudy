package com.groupthree.dao;

import com.groupthree.bean.CoffeeAddon;
import com.groupthree.bean.CoffeeSize;
import com.groupthree.util.OracleConnectionManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeAddonDao implements CoffeeAddonDaoInterface{


    @Override
    public ArrayList<CoffeeAddon> getCoffeeAddon() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        ArrayList<CoffeeAddon> coffeeAddons = new ArrayList<>();

        connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wiley123");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM COFFEE_ADDONS");

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            CoffeeAddon coffeeAddon= new CoffeeAddon();
            coffeeAddon.setCoffeeAddonId(resultSet.getInt("COFFEE_ADDON_ID"));
            coffeeAddon.setCoffeeAddonName(resultSet.getString("COFFEE_ADDON_NAME"));
            coffeeAddon.setCoffeeAddonPrice(resultSet.getInt("COFFEE_ADDON_PRICE"));

            coffeeAddons.add(coffeeAddon);
        }
        connection.close();
        return coffeeAddons ;

    }
}

