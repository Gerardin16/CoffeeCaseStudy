package com.groupthree.presentation;



import com.groupthree.bean.*;
import com.groupthree.service.*;
import com.groupthree.util.BeverageHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BeveragePresentationImpl implements BeveragePresentationInterface {
    BillTransactionServiceInterface transactionService=new BillTransactionService();
    BeverageHelper bvhelper=new BeverageHelper();
    CoffeeAddonService coffeeAddon=new CoffeeAddonService();
    CoffeeVoucherService coffeeVoucher= new CoffeeVoucherService();
    CoffeeSizeService coffeeSize=new CoffeeSizeService();
    CoffeeTypeService coffeeType=new CoffeeTypeService();


    Scanner input=new Scanner(System.in);
    int choice;
    String subChoice;
    String coffeeTypeChoice;
    String coffeeSizeChoice;
    String coffeeAddOnChoice;
    String voucherCode;
    String OrderNum;
    String InitialOrderNum=ORDER_NUMBER;
    int count=0;
    int randomNum;
    @Override
    public void showBeveragesMenu()  {

        try{
            System.out.println("Welcome to Group Three Coffee, Please place your order");
            randomNum=(int)Math.floor(Math.random()*100);
        	InitialOrderNum=InitialOrderNum+randomNum;
            do {
            	
                showCoffeeType();
                showCoffeeSize();
                showCoffeeAddon();
                System.out.println("Do you want to order more coffee?");
                subChoice = input.next();
                if(subChoice.equalsIgnoreCase("yes"))
                count++;

            }while(subChoice.equalsIgnoreCase("yes"));
            showVoucher();
           OrderNum=InitialOrderNum+"C"+count;
            transactionService.createCoffeeOrder();
            printBill();
            System.out.println("Happy Drink! Have a good day.");



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

    public void printBill() throws SQLException, ClassNotFoundException {
        ArrayList<CoffeeBill> coffeeBillList=transactionService.generateBill();
        for(CoffeeBill bill:coffeeBillList){
            bvhelper.displayCoffeeBill(bill);
        }

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
                if (voucherCode.equals(voucher.getVoucherCode().toString())) {
//                    transactionService.createCoffeeOrder();
                	int selectedVoucher=voucher.getVoucherId();
                	System.out.println("Order placed");
                }
            else
                {
                    System.out.println("The voucher code is not available");
                }
            System.out.println("=========================");
        }
    }

    public void showCoffeeAddon() throws SQLException, ClassNotFoundException {

        System.out.println("Choose your Add On");
        ArrayList<CoffeeAddon> coffeeAddonList=coffeeAddon.getCoffeeAddon();
        for(CoffeeAddon addOn:coffeeAddonList){
            bvhelper.displayCoffeeAddOn(addOn);
        }
       coffeeAddOnChoice = input.next();
        for(CoffeeAddon addon:coffeeAddonList){
            if (coffeeAddOnChoice.equals(addon.getCoffeeAddonName().toString()))  {
                int coffeeAddOnChoice=addon.getCoffeeAddonId();
            }
        }
        OrderNum=InitialOrderNum+"A"+count;
        transactionService.createCoffeeOrder();
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
            bvhelper.displayCoffeeSize(size);
        }
        coffeeSizeChoice = input.next();
        for(CoffeeSize size:coffeeSizeList){
            if  (coffeeSizeChoice.equals(size.getCoffeeSizeName().toString()))  {
                int selectedCoffeeSize=size.getCoffeeSizeId();
            }
        }
        System.out.println("=========================");
    }

    public void showCoffeeType() throws SQLException, ClassNotFoundException {

       System.out.println("Choose your coffee");
       ArrayList<CoffeeType> coffeeTypeList=coffeeType.getCoffeeType();
       for(CoffeeType type:coffeeTypeList){
           bvhelper.displayCoffeeType(type);
       }
       coffeeTypeChoice = input.next();
        for(CoffeeType type:coffeeTypeList){
            if (coffeeTypeChoice.equals(type.getCoffeeName().toString())) {
                int selectedCoffeeSize=type.getCoffeeId();

            }
        }

        System.out.println("=========================");



    }

}
