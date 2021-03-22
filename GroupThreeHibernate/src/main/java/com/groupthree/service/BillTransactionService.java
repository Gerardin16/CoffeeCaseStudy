package com.groupthree.service;

import com.groupthree.bean.CoffeeBill;
import java.util.UUID;
import com.groupthree.bean.CoffeeVoucher;
import com.groupthree.dao.BillTransactionDao;
import com.groupthree.dao.BillTransactionDaoInterface;
import com.groupthree.dao.CoffeeVoucherDao;
import com.groupthree.dao.CoffeeVoucherDaoInterface;
import com.groupthree.util.BeverageHelper;
import com.groupthree.util.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BillTransactionService implements BillTransactionServiceInterface{

    BillTransactionDaoInterface billTrans=new BillTransactionDao();
	CoffeeVoucherDaoInterface coffeeVoucher=new CoffeeVoucherDao();
	private Integer totalValue;


    @Override
    public ArrayList  generateBill(int person,String initialOrderNum, int selectedVoucher)
			 {
    	double totalValue=0;
    	double discount = 0;
    	double netValue;
    	double gstTax;
    	double stTax;
    	double totalBill;
		ArrayList displayBill=new ArrayList();
		
		
		ArrayList<CoffeeVoucher> coffeeVoucherList=coffeeVoucher.getCoffeeVoucher();
    	totalValue= billTrans.getOrders(person,initialOrderNum);
    
			if(selectedVoucher==0)
				discount=0.0;
			else
			{
				for(CoffeeVoucher voucher:coffeeVoucherList)
				{
			if(selectedVoucher==voucher.getVoucherId())
			{
				if(voucher.getVoucherCode().toString().equalsIgnoreCase("BZH30"))
					discount=0.3*totalValue;
				if(voucher.getVoucherCode().toString().equalsIgnoreCase("BZH20"))
					discount=0.2*totalValue;
				if(voucher.getVoucherCode().toString().equalsIgnoreCase("BZH10"))
					discount=0.1*totalValue;
			}
			}
				
		}
		netValue=totalValue-discount;
		gstTax=netValue*GST_TAX;
		gstTax=Math.round(gstTax);
		stTax=netValue*SERVICE_TAX;
		stTax=Math.round(stTax);
		totalBill=netValue+gstTax+stTax;
		totalBill=Math.round(totalBill);
		billTrans.createBill(person,initialOrderNum,selectedVoucher,totalBill);
		displayBill.add( Double.valueOf(totalValue));
		displayBill.add (discount);
		displayBill.add( netValue);
		displayBill.add( gstTax);
		displayBill.add( stTax);
		displayBill.add(totalBill);

		return  displayBill;
	}




	@Override
	public String createRandomOrderNumber() {
	
		String rand=UUID.randomUUID().toString().replace("-", "");
		rand=rand.substring(0,3);
		return rand;
	}






	@Override
	public void createCoffeeOrder(int person, String orderNum, int selectedCoffeeType, int selectedCoffeeSize,
			int selectedAddon) {
		billTrans.createOrder(person,orderNum,selectedCoffeeType,selectedCoffeeSize,selectedAddon);
		
	}




	@Override
	public List<OrderDetails> getDetailedOrders(int person, String initialOrderNum) {
		 return billTrans.getDetailedOrders(person,initialOrderNum);
	}







	



}
