package com.groupthree.dao;


import com.groupthree.bean.CoffeeAddon;
import com.groupthree.bean.CoffeeBill;
import com.groupthree.bean.CoffeeOrder;
import com.groupthree.util.OracleConnectionManagement;

import java.sql.*;
import java.util.ArrayList;

public class BillTransactionDao implements BillTransactionDaoInterface {

    private static final int NULL = 0;

	@Override
    public void createOrder(String orderNum, int selectedCoffeeType, int selectedCoffeeSize, int selectedAddon)
            throws ClassNotFoundException, SQLException {
        Connection connection = null;
         CoffeeOrder coffeeOrder=new CoffeeOrder();

        connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wiley123");

     
        String query="insert into COFFEE_ORDER (P_ID,ORDER_NUMBER, COFFEE_ID, COFFEE_SIZE_ID,COFFEE_ADDON_ID) values (?,?,?,?,?)";
      	
        PreparedStatement insertStatement=connection.prepareStatement(query);
        coffeeOrder.setOrderNumber(orderNum);
        coffeeOrder.setCoffeeId(selectedCoffeeType);
        coffeeOrder.setCoffeeSizeId(selectedCoffeeSize);
        if(selectedAddon==0)
        {
        	coffeeOrder.setCoffeeAddonId(NULL);
        }
        else
        {
        	coffeeOrder.setCoffeeAddonId(selectedAddon);
        }
//        need to change below value
        insertStatement.setInt(1, 4);
        insertStatement.setString(2, coffeeOrder.getOrderNumber());
        insertStatement.setInt(3, coffeeOrder.getCoffeeId());
        insertStatement.setInt(4, coffeeOrder.getCoffeeSizeId());
        insertStatement.setInt(5, coffeeOrder.getCoffeeAddonId());
        insertStatement.executeUpdate();

        connection.close();
    }

	@Override
	public ArrayList getOrders(String initialOrderNum) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		ArrayList<Integer> prices = new ArrayList<Integer>();
		String queryString="Select SUM(distinct(COFFEE_NAME_PRICE)) AS coffee_types_sum,SUM(COFFEE_SIZE_PRICE) AS coffee_sizes_sum,SUM(COFFEE_ADDON_PRICE) AS coffee_addons_sum  from COFFEE_ORDER co inner join COFFEE_TYPE ct\r\n"
				+ "on co.COFFEE_ID=ct.COFFEE_ID inner join COFFEE_SIZE cs on co.COFFEE_SIZE_ID=cs.COFFEE_SIZE_ID\r\n"
				+ "inner join COFFEE_ADDONS ca on co.COFFEE_ADDON_ID=ca.COFFEE_ADDON_ID where ORDER_NUMBER LIKE '"+initialOrderNum+"%'";

		connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wiley123");
		PreparedStatement statement = connection.prepareStatement(queryString);

		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {


			prices.add(resultSet.getInt("COFFEE_TYPES_SUM"));
			prices.add(resultSet.getInt("COFFEE_SIZES_SUM"));
			prices.add(resultSet.getInt("COFFEE_ADDONS_SUM"));


		}
		connection.close();
		return prices ;
	}

	@Override
	public void createBill(String initialOrderNum, int selectedVoucher, double totalBill) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		CoffeeBill coffeeBill=new CoffeeBill();

		connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wiley123");

		PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM BILL_ORDER");
		ResultSet resultSet= selectStatement.executeQuery();
		int rowCount=0;
		while(resultSet.next()) {
			rowCount=rowCount+1;
		}
		rowCount++;
		Statement insertStatement=connection.createStatement();
		coffeeBill.setBillId(rowCount);
		coffeeBill.setOrderNumber(initialOrderNum);
		if (selectedVoucher==0)	
		coffeeBill.setVoucherId(NULL);
		else
		coffeeBill.setVoucherId(selectedVoucher);
			
		coffeeBill.setTotalAmt(totalBill);
		String query="Insert into BILL_ORDER values("+coffeeBill.getBillId()+
				",'"+coffeeBill.getOrderNumber()+"','"+coffeeBill.getVoucherId()+"','"+coffeeBill.getTotalAmt()+
				"')";

		int rows=insertStatement.executeUpdate(query);
		connection.close();
	}


}
