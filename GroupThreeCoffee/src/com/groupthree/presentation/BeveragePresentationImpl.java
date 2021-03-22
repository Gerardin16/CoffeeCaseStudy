package com.groupthree.presentation;



import com.groupthree.bean.*;
import com.groupthree.service.*;
import com.groupthree.util.BeverageHelper;
import com.groupthree.util.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class BeveragePresentationImpl implements BeveragePresentationInterface {
    BillTransactionServiceInterface transactionService=new BillTransactionService();
    BeverageHelper bvhelper;
    PersonDetailsServiceInterface personDetails = new PersonDetailsService();
    CoffeeAddonServiceInterface coffeeAddon=new CoffeeAddonService();
    CoffeeVoucherServiceInterface coffeeVoucher= new CoffeeVoucherService();
    CoffeeSizeServiceInterface coffeeSize=new CoffeeSizeService();
    CoffeeTypeServiceInterface coffeeType=new CoffeeTypeService();
    
    private int selectedCoffeeSize;
    private  int selectedVoucher;
    private int selectedAddon;
    private int selectedCoffeeType;
    private int choice;
    private String subChoice;
    private String coffeeTypeChoice;
    private int selectedPerson;
    private String coffeeSizeChoice;
    private String coffeeAddOnChoice;
    private String voucherCode;
    private String OrderNum;
    private String initialOrderNum=ORDER_NUMBER;
    private String randomNum;
	private long personPhoneno;
    private String selectedVoucherCode;
    
    public String getSelectedVoucherCode() {
		return selectedVoucherCode;
	}

	public void setSelectedVoucherCode(String selectedVoucherCode) {
		this.selectedVoucherCode = selectedVoucherCode;
	}

    public int getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(int selectedPerson) {
		this.selectedPerson = selectedPerson;
	}

	public void setSelectedCoffeeSize(int selectedCoffeeSize) {
        this.selectedCoffeeSize = selectedCoffeeSize;
    }

    public void setSelectedVoucher(int selectedVoucher) {
        this.selectedVoucher = selectedVoucher;
    }

    public void setSelectedAddon(int selectedAddon) {
        this.selectedAddon = selectedAddon;
    }

    public void setSelectedCoffeeType(int selectedCoffeeType) {
        this.selectedCoffeeType = selectedCoffeeType;
    }
    

    Scanner input=new Scanner(System.in);


	@Override
	public void showBeveragesMenu(int selectedPerson) {
		// TODO Auto-generated method stub
		try{
            System.out.println("Please place your order");
//            Generation of an order number
            randomNum=transactionService.createRandomOrderNumber();
            OrderNum=initialOrderNum+randomNum;
            do {
            	
                showCoffeeType();
                showCoffeeSize();
                System.out.println("Do you want  Add-ons?");
                subChoice=input.next();
                if(subChoice.equalsIgnoreCase("yes"))
                {
                    showCoffeeAddon();
                   
                }
                else
                {
//                	Placing order
                	transactionService.createCoffeeOrder(selectedPerson,OrderNum,selectedCoffeeType,selectedCoffeeSize,selectedAddon);
                }
                System.out.println("Do you want to order more coffee?");
                subChoice = input.next();
               
             

            }while(subChoice.equalsIgnoreCase("yes"));
            showVoucher();

            printBill(selectedPerson,OrderNum,selectedVoucher);
            System.out.println("Happy Drink! Have a good day.");
            System.out.println("================================");



        }
        catch(ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please provide a correct input");
        }
        catch (NullPointerException en)
        {
            System.out.println(en.getMessage());
        }
		
	}
//	Customer Details check
	@Override
	public int showPersonDetails() {
		try {
		PersonDetails person;
		System.out.println("Welcome to Group Three Coffee, Please enter your registered phone number");
    	personPhoneno = input.nextLong();
    	person=personDetails.searchRecordByPhoneno(personPhoneno);
    		if(person!=null) {
        		System.out.println("Welcome "+person.getPersonName());
       		}
		
		else {
			System.out.println("Please give your name");
    		String personName=input.next();
    		person=personDetails.insertPerson(personName,personPhoneno);
    		System.out.println("Welcome "+person.getPersonName());
    		}
    		selectedPerson=person.getpId();
    		
		}
	      catch(ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        }
    
        catch (NullPointerException en)
        {
            System.out.println(en.getMessage());
        }
		return selectedPerson;
	}
//	Get Coffee details
    public void showCoffeeType() {
    	try {
        System.out.println("Choose your coffee");
        ArrayList<CoffeeType> coffeeTypeList=coffeeType.getCoffeeType();
        for(CoffeeType type:coffeeTypeList){
            BeverageHelper.displayCoffeeType(type);
        }
        coffeeTypeChoice = input.next();
         for(CoffeeType type:coffeeTypeList){
             if (coffeeTypeChoice.equalsIgnoreCase(type.getCoffeeName().toString())) {
                 selectedCoffeeType=type.getCoffeeId();

             }
         }

         System.out.println("=========================");

    	}
        catch(ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        }
    
        catch (NullPointerException en)
        {
            System.out.println(en.getMessage());
        }
     }
//    Get Size details
    public void showCoffeeSize()  {
    	try {
        System.out.println("Choose your size");
        ArrayList<CoffeeSize> coffeeSizeList=coffeeSize.getCoffeeSize();
        for(CoffeeSize size:coffeeSizeList){
            BeverageHelper.displayCoffeeSize(size);
        }
        coffeeSizeChoice = input.next();
        for(CoffeeSize size:coffeeSizeList){
            if  (coffeeSizeChoice.equalsIgnoreCase(size.getCoffeeSizeName().toString()))  {
               selectedCoffeeSize=size.getCoffeeSizeId();
            }
        }
        System.out.println("=========================");

    	}
        catch(ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        }
    
        catch (NullPointerException en)
        {
            System.out.println(en.getMessage());
        }
    }
//  Get Add ons details
    public void showCoffeeAddon()  {
    	try {
        System.out.println("Choose your Add On");
        ArrayList<CoffeeAddon> coffeeAddonList=coffeeAddon.getCoffeeAddon();
        for(CoffeeAddon addOn:coffeeAddonList){
            BeverageHelper.displayCoffeeAddOn(addOn);
        }
       coffeeAddOnChoice = input.next();
        for(CoffeeAddon addon:coffeeAddonList){
            if (coffeeAddOnChoice.equalsIgnoreCase(addon.getCoffeeAddonName().toString()))  {
                selectedAddon=addon.getCoffeeAddonId();
            }
        }
//        Placing order
        transactionService.createCoffeeOrder(selectedPerson,OrderNum,selectedCoffeeType,selectedCoffeeSize,selectedAddon);
        System.out.println("=========================");
        System.out.println("Do you want more Add-ons?");
        subChoice=input.next();
        if(subChoice.equalsIgnoreCase("yes"))
        {
        	
            showCoffeeAddon();
           
           
        }
    	}
        catch(ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        }
    
        catch (NullPointerException en)
        {
            System.out.println(en.getMessage());
        }
    }
//    Get voucher details
    public void showVoucher()  {
    	try {
        System.out.println("Do you have any discount voucher?");
        subChoice=input.next();
        if(subChoice.equalsIgnoreCase("yes"))
        {
            
            ArrayList<CoffeeVoucher> coffeeVoucherList=coffeeVoucher.getCoffeeVoucher();
            System.out.println("Voucher code,please ");
            voucherCode=input.next();
            for(CoffeeVoucher voucher:coffeeVoucherList)
                if (voucherCode.equalsIgnoreCase(voucher.getVoucherCode().toString())) {
                	selectedVoucher=voucher.getVoucherId();
                	selectedVoucherCode = voucher.getVoucherCode();
                }
            System.out.println("=========================");
        }
    	}
        catch(ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        }
    
        catch (NullPointerException en)
        {
            System.out.println(en.getMessage());
        }
    	
    }
//    Print bill
    public void printBill(int person,String initialOrderNum, int selectedVoucher) {
    	try {
    	ArrayList<OrderDetails> orders=transactionService.getDetailedOrders(person,initialOrderNum);
        ArrayList bill =transactionService.generateBill(person,OrderNum,selectedVoucher);
    	
    		System.out.println("---------------Final Invoice-------------------");
    		System.out.println("Your order number is :"+initialOrderNum);
    		System.out.println("You have ordered the below items");
 		System.out.println("Coffee--Size--Addon")	;
 		for(OrderDetails ord:orders){
 			if (ord.getOrdCoffeeAddon().equalsIgnoreCase("DUMMY"))
 				ord.setOrdCoffeeAddon("No Addon");
 			 BeverageHelper.displayDetailedOrders(ord);
 	       }
         BeverageHelper.displayCoffeeBill(bill,selectedVoucherCode );
    
    }
    catch(ClassNotFoundException | SQLException ex)
    {
        ex.printStackTrace();
    }

    catch (NullPointerException en)
    {
        System.out.println(en.getMessage());
    }
    }
}
		

