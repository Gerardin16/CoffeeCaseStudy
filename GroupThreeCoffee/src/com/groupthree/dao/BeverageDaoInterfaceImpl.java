package com.groupthree.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.group3.util.OracleConnectionManagement;
import com.groupthree.bean.Beverage;

public abstract class BeverageDaoInterfaceImpl implements CoffeeTypeDaoInterface{

	@Override
	public ArrayList<Beverage> getAllRecords() throws ClassNotFoundException, SQLException {

		Connection connection = null;
		ArrayList<Beverage> empList = new ArrayList<>();

		connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","wiley123");
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM BEVERAGE");

		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {

			Beverage beverage = new Beverage();
			beverage.setCoffeeType(resultSet.getString("CoffeeType"));
			beverage.setCoffeeSize(resultSet.getString("CoffeeSize"));
			beverage.setCoffeeAddon(resultSet.getString("CoffeeAddon"));
			beverage.setVoucher(resultSet.getString("Voucher"));
			beverage.setOrder(resultSet.getInt("Order"));
			beverage.setBill(resultSet.getInt("Bill"));

			empList.add(beverage);
		}
		connection.close();
		return empList;
	}

//	@Override
//	public Beverage searchRecordById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
