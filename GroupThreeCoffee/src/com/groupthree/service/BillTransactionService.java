package com.groupthree.service;

import com.groupthree.bean.CoffeeBill;
import com.groupthree.bean.CoffeeVoucher;
import com.groupthree.dao.BillTransactionDao;
import com.groupthree.dao.BillTransactionDaoInterface;
import com.groupthree.dao.CoffeeVoucherDao;
import com.groupthree.dao.CoffeeVoucherDaoInterface;
import com.groupthree.util.BeverageHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BillTransactionService implements BillTransactionServiceInterface{

    BillTransactionDaoInterface billTrans=new BillTransactionDao();
	CoffeeVoucherDaoInterface coffeeVoucher=new CoffeeVoucherDao();


    @Override
    public TreeMap<String,Double> generateBill(String initialOrderNum, int selectedVoucher)
			throws ClassNotFoundException, SQLException {
    	Integer totalValue = null;
    	Double discount=null;
    	Double netValue;
    	Double gstTax;
    	Double stTax;
    	Double totalBill;
		Map<String,Double> displayBill=new TreeMap<String,Double>();

    	ArrayList<Integer> pricesList= billTrans.getOrders(initialOrderNum);
    	 for(Integer price:pricesList)
		 {
				totalValue+=price;
		 }
		ArrayList<CoffeeVoucher> coffeeVoucherList=coffeeVoucher.getCoffeeVoucher();
		for(CoffeeVoucher voucher:coffeeVoucherList)
		{
			if(selectedVoucher==voucher.getVoucherId())
			{
				if(voucher.getVoucherCode()=="BZH30")
					discount=0.3*totalValue;
				if(voucher.getVoucherCode()=="BZH20")
					discount=0.2*totalValue;
				if(voucher.getVoucherCode()=="BZH10")
					discount=0.1*totalValue;
			}
		}
		netValue=totalValue-discount;
		gstTax=netValue*GST_TAX;
		stTax=netValue*SERVICE_TAX;
		totalBill=netValue+gstTax+stTax;
		billTrans.createBill(initialOrderNum,selectedVoucher,totalBill);
		displayBill.put("Total Value", Double.valueOf(totalValue));
		displayBill.put("Discount", discount);
		displayBill.put("Net Value", netValue);
		displayBill.put("GST", gstTax);
		displayBill.put("Service Tax", stTax);
		displayBill.put("Total Bill", totalBill);

		return (TreeMap<String, Double>) displayBill;
	}




	@Override
	public int createRandomOrderNumber() {
		return (int) Math.floor((Math.random()*100));
	}


	@Override
	public void createCoffeeOrder(String orderNum, int selectedCoffeeType, int selectedCoffeeSize, int selectedAddon)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

        billTrans.createOrder(orderNum,selectedCoffeeType,selectedCoffeeSize,selectedAddon);
		
	}

	@Override
	public String generateOrderNumber(String initialOrderNum, String c, int count) {
		return initialOrderNum+c+count;
	}


}
