package com.groupthree.dao;


import com.groupthree.bean.CoffeeAddon;
import com.groupthree.bean.CoffeeBill;
import com.groupthree.bean.CoffeeOrder;
import com.groupthree.util.OracleConnectionManagement;
import com.groupthree.util.OrderDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



public class BillTransactionDao implements BillTransactionDaoInterface {

	 private static final int NULL = 0;

	@Override
    public void createOrder(int person,String orderNum, int selectedCoffeeType, int selectedCoffeeSize, int selectedAddon)
            throws ClassNotFoundException, SQLException {
        Connection connection = null;
         CoffeeOrder coffeeOrder=new CoffeeOrder();

        connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wiley123");

     
        String query="insert into COFFEE_ORDER (P_ID,ORDER_NUMBER, COFFEE_ID, COFFEE_SIZE_ID,COFFEE_ADDON_ID) values (?,?,?,?,?)";
      	
        PreparedStatement insertStatement=connection.prepareStatement(query);
        coffeeOrder.setPersonId(person);
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
        insertStatement.setInt(1, coffeeOrder.getPersonId());
        insertStatement.setString(2, coffeeOrder.getOrderNumber());
        insertStatement.setInt(3, coffeeOrder.getCoffeeId());
        insertStatement.setInt(4, coffeeOrder.getCoffeeSizeId());
        insertStatement.setInt(5, coffeeOrder.getCoffeeAddonId());
        insertStatement.executeUpdate();

        connection.close();
    }

	@Override
	public double getOrders(int person,String initialOrderNum) throws SQLException, ClassNotFoundException {
		 double totalSum=0.0;
		Connection connection = null;
//		ArrayList<Integer> prices = new ArrayList<Integer>();
		String queryString="Select  SUM(COFFEE_NAME_PRICE+COFFEE_SIZE_PRICE+COFFEE_ADDON_PRICE) as TOTAL_SUM  from COFFEE_ORDER co inner join COFFEE_TYPE ct\r\n"
				+ "on co.COFFEE_ID=ct.COFFEE_ID inner join COFFEE_SIZE cs on co.COFFEE_SIZE_ID=cs.COFFEE_SIZE_ID\r\n"
				+ "inner join COFFEE_ADDONS ca on co.COFFEE_ADDON_ID=ca.COFFEE_ADDON_ID where P_ID="+person+"and ORDER_NUMBER='"+initialOrderNum+"'";

		connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wiley123");
		PreparedStatement statement = connection.prepareStatement(queryString);

		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {

			totalSum=resultSet.getDouble("TOTAL_SUM");
//			prices.add(resultSet.getInt("COFFEE_TYPES_SUM"));
//			prices.add(resultSet.getInt("COFFEE_SIZES_SUM"));
//			prices.add(resultSet.getInt("COFFEE_ADDONS_SUM"));


		}
		connection.close();
		return totalSum ;
	}

	@Override
	public void createBill(int person,String initialOrderNum, int selectedVoucher, double totalBill) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		CoffeeBill coffeeBill=new CoffeeBill();

		connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wiley123");
		   String query="insert into BILL_ORDER (P_ID,ORDER_NUMBER,VOUCHER_ID,TOTAL_BILL_AMT) values (?,?,?,?)";
		PreparedStatement insertStatement = connection.prepareStatement(query);
	
		coffeeBill.setPersonId(person);
		coffeeBill.setOrderNumber(initialOrderNum);
		if (selectedVoucher==0)	
		coffeeBill.setVoucherId(NULL);
		else
		coffeeBill.setVoucherId(selectedVoucher);
			
		coffeeBill.setTotalAmt(totalBill);
		
		  insertStatement.setInt(1, coffeeBill.getPersonId());
	        insertStatement.setString(2, coffeeBill.getOrderNumber());
	        insertStatement.setInt(3, coffeeBill.getVoucherId());
	        insertStatement.setDouble(4, coffeeBill.getTotalAmt());
	       
		 insertStatement.executeUpdate();
		connection.close();
	}

	@Override
	public ArrayList getDetailedOrders(int person, String initialOrderNum) throws ClassNotFoundException, SQLException {
		Connection connection = null;
	    ArrayList<OrderDetails> orders = new ArrayList<>();
	    connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wiley123");
	    String queryString="select ct.COFFEE_NAME as Coffee_Name,cs.COFFEE_SIZE as Coffee_size,ca.COFFEE_ADDON_NAME as Coffee_Addon from COFFEE_ORDER co inner join COFFEE_TYPE ct"
				+" on co.COFFEE_ID=ct.COFFEE_ID inner join COFFEE_SIZE cs on co.COFFEE_SIZE_ID=cs.COFFEE_SIZE_ID"
				+" inner join COFFEE_ADDONS ca on co.COFFEE_ADDON_ID=ca.COFFEE_ADDON_ID where P_ID="+person+"and ORDER_NUMBER='"+initialOrderNum+"'";
	    PreparedStatement statement = connection.prepareStatement(queryString);

	    ResultSet resultSet = statement.executeQuery();
	    while (resultSet.next()) {
	    	
	    OrderDetails orderDetails=new OrderDetails();
	    orderDetails.setOrdCoffeeType(resultSet.getString("Coffee_Name"));
	    orderDetails.setOrdCoffeeSize(resultSet.getString("Coffee_Size"));
	    orderDetails.setOrdCoffeeAddon(resultSet.getString("Coffee_Addon"));
	    orders.add(orderDetails);
	    }
	    connection.close();
		return  orders;


}
}
	
	

   
    

  
