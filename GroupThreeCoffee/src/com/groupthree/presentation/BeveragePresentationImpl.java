package com.groupthree.presentation;

import com.groupthree.service.BeveragesServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class BeveragePresentationImpl implements BeveragePresentationInterface {

    private BeveragesServiceImpl beveragesService =new BeveragesServiceImpl();
    Scanner input=new Scanner(System.in);
    @Override
    public void showBeveragesMenu() {
        System.out.println("Welcome to Group Three Coffee, Please place your order");
        System.out.println("Choose your coffee");
        beveragesService.getCoffeeType();
        ArrayList<CoffeeType> empList=beveragesService.getCoffeeType();
        for(CoffeeType coffeeType:coffeeTypeList{
            CoffeeUtility.displayCoffeeType(coffeeType);
        }
        System.out.println("=========================");
    }

    @Override
    public void chooseChoice(int choice) {
        try{
            System.out.println("Choose your size");
            beveragesService.getCoffeeSize();
            ArrayList<CoffeeSize> empList=beveragesService.getCoffeeSize();
            for(CoffeeSize coffeeSize:coffeeSizeList{
                CoffeeUtility.displayCoffeeSize(coffeeSize);
            }
            System.out.println("=========================");
        }
        catch(ClassNotFoundException| SQLException ex){
            ex.printStackTrace();
        }
    }
}
