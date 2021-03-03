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

    Scanner input=new Scanner(System.in);
    int choice;
    String subChoice;
    String coffeeTypeChoice;
    String coffeeSizeChoice;
    String coffeeAddOnChoice;
    String voucherCode;
    String OrderNumber;
    int count=0;
    @Override
    public void showBeveragesMenu() {

        try{
            System.out.println("Welcome to Group Three Coffee, Please place your order");
            showCoffeeType();
            showCoffeeSize();
            populateOrderNum();
            showCoffeeAddon();
            populateOrderNum();
            transactionService.createUpdateOrder();
            System.out.println("Do you want to order more coffee?");
            subChoice=input.next();
            if(subChoice.equalsIgnoreCase("yes"))
            {
                showCoffeeType();
                count++
            }
            showVoucher();
            populateOrderNum();
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
            System.out.println("We are closed");
        }
    }

    public void printBill() throws SQLException, ClassNotFoundException {
        ArrayList<CoffeeBill> coffeeBillList=transactionService.generateBill();
        for(CoffeeBill bill:coffeeBillList){
            bvhelper.displayCoffeeBill(bill);
        }

    }

    @Override
    public void populateOrderNum() throws SQLException, ClassNotFoundException {
            if(count==0)
            OrderNumber="ORDER"+Math.random();
            else
            OrderNumber+=count;
    }

    public void showVoucher() throws SQLException, ClassNotFoundException {
        System.out.println("Do you have any discount voucher?");
        subChoice=input.next();
        if(subChoice.equalsIgnoreCase("yes"))
        {
            CoffeeVoucherService coffeeVoucher= new CoffeeVoucherService();
            ArrayList<CoffeeVoucher> coffeeVoucherList=coffeeVoucher.getCoffeeVoucher();
            System.out.println("Voucher code,please ");
            voucherCode=input.next();
            for(CoffeeVoucher voucher:coffeeVoucherList)
                if (voucher.getVoucherCode()==voucherCode) {
                    transactionService.createUpdateOrder();
                }
            else
                {
                    System.out.println("The voucher code is not available");
                }
            System.out.println("=========================");
        }
    }

    public void showCoffeeAddon() throws SQLException, ClassNotFoundException {
        CoffeeAddonService coffeeAddon=new CoffeeAddonService();
        ArrayList<CoffeeAddon> coffeeAddonList=coffeeAddon.getCoffeeAddon();
        for(CoffeeAddon addOn:coffeeAddonList){
            bvhelper.displayCoffeeAddOn(addOn);
        }
       coffeeAddOnChoice = input.next();
        transactionService.createUpdateOrder();
        System.out.println("=========================");
        System.out.println("Do you want more Add-ons?");
        subChoice=input.next();
        if(subChoice.equalsIgnoreCase("yes"))
        {
            showCoffeeAddon();
            count++;
        }
    }

    public void showCoffeeSize() throws SQLException, ClassNotFoundException {
        CoffeeSizeService coffeeSize=new CoffeeSizeService();
        System.out.println("Choose your size");
        ArrayList<CoffeeSize> coffeeSizeList=coffeeSize.getCoffeeSize();
        for(CoffeeSize size:coffeeSizeList){
            bvhelper.displayCoffeeSize(size);
        }
        coffeeSizeChoice = input.next();
        transactionService.createUpdateOrder();
        System.out.println("=========================");
    }

    public void showCoffeeType() throws SQLException, ClassNotFoundException {
       CoffeeTypeService coffeeType=new CoffeeTypeService();
       System.out.println("Choose your coffee");
       ArrayList<CoffeeType> coffeeTypeList=coffeeType.getCoffeeType();
       for(CoffeeType type:coffeeTypeList){
           bvhelper.displayCoffeeType(type);
       }
       coffeeTypeChoice = input.next();

//       int index=coffeeTypeList.indexOf(new CoffeeType(coffeeTypeChoice));
//        System.out.println(index);
        System.out.println("=========================");


    }

}
