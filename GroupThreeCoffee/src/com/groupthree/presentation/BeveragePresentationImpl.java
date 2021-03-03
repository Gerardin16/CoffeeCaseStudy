package com.groupthree.presentation;



import com.groupthree.service.*;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BeveragePresentationImpl implements BeveragePresentationInterface {


    Scanner input=new Scanner(System.in);
    int choice;
    String subChoice;
    String voucherCode;
    @Override
    public void showBeveragesMenu() {
        BillTransactionService transactionService=new BillTransactionService();
        try{
            System.out.println("Welcome to Group Three Coffee, Please place your order");
            showCoffeeType();
            showCoffeeSize();
            showCoffeeAddon();
            System.out.println("Do you want to order more coffee?");
            subChoice=input.next();
            if(subChoice.equalsIgnoreCase("yes"))
            {
                showCoffeeType();
            }
            showVoucher();
            printBill();
            System.out.println("Happy Drink! Have a good day.");


        }
        catch (InputMismatchException e)
        {
            System.out.println("Please provide a correct input");
        }
    }

    public void printBill() {
        BeverageHelper.displayBill();
    }

    public void showVoucher() {
        System.out.println("Do you have any discount voucher?");
        subChoice=input.next();
        if(subChoice.equalsIgnoreCase("yes"))
        {
            CoffeeVoucherService coffeeVoucher= new CoffeeVoucherService();
            ArrayList<CoffeeVoucher> coffeeVoucherList=coffeeVoucher.getCoffeVoucher();
            System.out.println("Voucher code,please ");
            voucherCode=input.next();
            for(CoffeeVoucher voucher:coffeeVoucherList)
                if (voucher.ToString()==voucherCode) {
                    transactionService.createUpdateOrder(choice);
                }
            else
                {
                    System.out.println("The voucher code is not available");
                }
            System.out.println("=========================");
        }
    }

    public void showCoffeeAddon() {
        CoffeeAddonService coffeeAddon=new CoffeeAddonService();
        ArrayList<CoffeeAddon> coffeeAddonList=coffeeAddon.getCoffeeAddon();
        for(CoffeeAddon addOn:coffeeAddonList){
            BeverageHelper.displayCoffeeAddon(coffeeAddon);
        }
        choice = input.nextInt();
        transactionService.createUpdateOrder(choice);
        System.out.println("=========================");
        System.out.println("Do you want more Add-ons?");
        subChoice=input.next();
        if(subChoice.equalsIgnoreCase("yes"))
        {
            showCoffeeAddon();
        }
    }

    public void showCoffeeSize() {
        CoffeeSizeService coffeeSize=new CoffeeSizeService();
        System.out.println("Choose your size");
        ArrayList<CoffeeSize> coffeeSizeList=coffeeSize.getCoffeeSize();
        for(CoffeeSize size:coffeeSizeList){
            BeverageHelper.displayCoffeeSize(coffeeSize);
        }
        choice = input.nextInt();
        transactionService.createUpdateOrder(choice);
        System.out.println("=========================");
    }

    public void showCoffeeType() {
       CoffeeTypeService coffeeType=new CoffeeTypeService();
       System.out.println("Choose your coffee");
       ArrayList<CoffeeType> coffeeTypeList=coffeeType.getCoffeeType();
       for(CoffeeType type:coffeeTypeList){
           BeverageHelper.displayCoffeeType();
       }
       choice = input.nextInt();
       transactionService.createUpdateOrder(choice);
       System.out.println("=========================");
    }

}
