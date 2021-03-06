package com.groupthree.presentation;



import com.groupthree.bean.*;
import com.groupthree.service.*;
import com.groupthree.util.BeverageHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class BeveragePresentationImpl implements BeveragePresentationInterface {
    BillTransactionServiceInterface transactionService=new BillTransactionService();
    BeverageHelper bvhelper;
    PersonDetailsService personDetails = new PersonDetailsService();
    CoffeeAddonService coffeeAddon=new CoffeeAddonService();
    CoffeeVoucherService coffeeVoucher= new CoffeeVoucherService();
    CoffeeSizeService coffeeSize=new CoffeeSizeService();
    CoffeeTypeService coffeeType=new CoffeeTypeService();
    private int selectedCoffeeSize;
    private  int selectedVoucher;
    private int selectedAddon;
    private int selectedCoffeeType;
    private int choice;
    private String subChoice;
    private String coffeeTypeChoice;

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
    
    private String coffeeSizeChoice;
    private String coffeeAddOnChoice;
    private String voucherCode;
    private String OrderNum;
    private String initialOrderNum=ORDER_NUMBER;
    private int count;
    private String randomNum;
    Scanner input=new Scanner(System.in);


    @Override
    public void showBeveragesMenu()  {

        try{
            System.out.println("Welcome to Group Three Coffee, Please place your order");
            count=0;
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
                	transactionService.createCoffeeOrder(OrderNum,selectedCoffeeType,selectedCoffeeSize,selectedAddon);
                }
                System.out.println("Do you want to order more coffee?");
                subChoice = input.next();
               
             

            }while(subChoice.equalsIgnoreCase("yes"));
            showVoucher();

            printBill(initialOrderNum,selectedVoucher);
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

    public void printBill(String initialOrderNum, int selectedVoucher) throws SQLException, ClassNotFoundException {
       ArrayList bill =transactionService.generateBill(OrderNum,selectedVoucher);
        BeverageHelper.displayCoffeeBill(bill);

    }
   
    public void showPersonDetails1() throws SQLException, ClassNotFoundException {
    	System.out.println("Welcome to Group Three Coffee, Please enter your registered phone number");
    	PersonDetailsDao personDetailsDoa=new PersonDetailsDao();
    	personPhoneno = input.nextLong();
    	PersonDetails perDe=personDetailsDoa.searchRecordByPhoneno(personPhoneno);
    		if(perDe!=null) {
    			BeverageHelper.displayPersonName(perDe);
        		System.out.println("Welcome "+perDe.getPersonName());
       		}
		
		else
			System.out.println("Please enter your details to get registered");
    		System.out.println("=========================");
    		
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
        transactionService.createCoffeeOrder(OrderNum,selectedCoffeeType,selectedCoffeeSize,selectedAddon);
        System.out.println("=========================");
        System.out.println("Do you want more Add-ons?");
        subChoice=input.next();
        if(subChoice.equalsIgnoreCase("yes"))
        {
        	 count++;
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

}
