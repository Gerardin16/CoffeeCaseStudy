package com.groupthree.dao;
import java.sql.SQLException;
import java.util.ArrayList;

import com.groupthree.bean.Beverage;

public interface CoffeeAddonDaoInterface {

	ArrayList<Beverage> getAllRecords() throws ClassNotFoundException, SQLException;
	Beverage searchRecordById(int id);
}
