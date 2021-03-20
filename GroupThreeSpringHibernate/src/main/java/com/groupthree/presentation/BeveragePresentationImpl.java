package com.groupthree.presentation;



import com.groupthree.bean.*;


import com.groupthree.service.*;
import com.groupthree.util.BeverageHelper;
import com.groupthree.util.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("presentation")
public class BeveragePresentationImpl implements BeveragePresentationInterface {
	@Autowired
    private BillTransactionServiceInterface transactionService;
	@Autowired
    private PersonDetailsServiceInterface personDetails;
	@Autowired
    private CoffeeAddonServiceInterface coffeeAddon;
	@Autowired
    private CoffeeVoucherServiceInterface coffeeVoucher;
	@Autowired
    private CoffeeSizeServiceInterface coffeeSize;
	@Autowired
    private CoffeeTypeServiceInterface coffeeType;
	private BeverageHelper bvhelper;
	   
	   
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

    
    public BillTransactionServiceInterface getTransactionService() {
		return transactionService;
	}

	public void setTransactionService(BillTransactionServiceInterface transactionService) {
		this.transactionService = transactionService;
	}

	public PersonDetailsServiceInterface getPersonDetails() {
		return personDetails;
	}

	public void setPersonDetails(PersonDetailsServiceInterface personDetails) {
		this.personDetails = personDetails;
	}

	public CoffeeAddonServiceInterface getCoffeeAddon() {
		return coffeeAddon;
	}

	public void setCoffeeAddon(CoffeeAddonServiceInterface coffeeAddon) {
		this.coffeeAddon = coffeeAddon;
	}

	public CoffeeVoucherServiceInterface getCoffeeVoucher() {
		return coffeeVoucher;
	}

	public void setCoffeeVoucher(CoffeeVoucherServiceInterface coffeeVoucher) {
		this.coffeeVoucher = coffeeVoucher;
	}

	public CoffeeSizeServiceInterface getCoffeeSize() {
		return coffeeSize;
	}

	public void setCoffeeSize(CoffeeSizeServiceInterface coffeeSize) {
		this.coffeeSize = coffeeSize;
	}

	public CoffeeTypeServiceInterface getCoffeeType() {
		return coffeeType;
	}

	public void setCoffeeType(CoffeeTypeServiceInterface coffeeType) {
		this.coffeeType = coffeeType;
	}

	public BeverageHelper getBvhelper() {
		return bvhelper;
	}

	public void setBvhelper(BeverageHelper bvhelper) {
		this.bvhelper = bvhelper;
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
	public void showBeveragesMenu(int selectedPerson) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try{
            System.out.println("Please place your order");
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


    public void printBill(int person,String initialOrderNum, int selectedVoucher) throws SQLException, ClassNotFoundException {
    	List<OrderDetails> orders=transactionService.getDetailedOrders(person,initialOrderNum);
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

    
   
 
    	


    public void showVoucher() throws SQLException, ClassNotFoundException {
        System.out.println("Do you have any discount voucher?");
        subChoice=input.next();
        if(subChoice.equalsIgnoreCase("yes"))
        {
            
            ArrayList<CoffeeVoucher> coffeeVoucherList=coffeeVoucher.getCoffeeVoucher();
            System.out.println("Voucher code,please ");
            voucherCode=input.next();
            for(CoffeeVoucher voucher:coffeeVoucherList)
                if (voucherCode.equalsIgnoreCase(voucher.getVoucherCode().toString())) {
//                    transactionService.createCoffeeOrder();
                	selectedVoucher=voucher.getVoucherId();
//                	System.out.println("Order placed");
                }
            System.out.println("=========================");
        }
    }

    public void showCoffeeAddon() throws SQLException, ClassNotFoundException {
    
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
        transactionService.createCoffeeOrder(selectedPerson,OrderNum,selectedCoffeeType,selectedCoffeeSize,selectedAddon);
        System.out.println("=========================");
        System.out.println("Do you want more Add-ons?");
        subChoice=input.next();
        if(subChoice.equalsIgnoreCase("yes"))
        {
        	
            showCoffeeAddon();
           
           
        }
    }

    public void showCoffeeSize() throws SQLException, ClassNotFoundException {

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

    public void showCoffeeType() throws SQLException, ClassNotFoundException {

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

	@Override
	public int showPersonDetails() throws ClassNotFoundException, SQLException {
		ArrayList<PersonDetails> person;
		System.out.println("Welcome to Group Three Coffee, Please enter your registered phone number");
    	personPhoneno = input.nextLong();
    	person=personDetails.searchRecordByPhoneno(personPhoneno);
    		if(person.size()!=0) {
    			 for(PersonDetails per:person){
    				 System.out.println("Welcome "+per.getPersonName());
    				 selectedPerson=per.getpId();
    		       }
        
       		}
		
		else {
			System.out.println("Please give your name");
    		String personName=input.next();
    		personDetails.insertPerson(personName,personPhoneno);
    		person=personDetails.searchRecordByPhoneno(personPhoneno);
    		if(person.size()!=0) {
   			 for(PersonDetails per:person){
   				 System.out.println("Welcome "+per.getPersonName());
   				 selectedPerson=per.getpId();
   		       }
       
      		}
    	}
    		
    		return selectedPerson;
	}


}
		

