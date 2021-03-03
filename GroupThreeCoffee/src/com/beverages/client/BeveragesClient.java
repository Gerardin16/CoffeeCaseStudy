package com.beverages.client;

import com.groupthree.presentation.BeveragePresentationImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BeveragesClient {

    public static void main(String[] args) {

        BeveragePresentationImpl beveragePresentation = new BeveragePresentationImpl();
        int choice = 0;
        Scanner input = new Scanner(System.in);
        try {
            while (true) {
                beveragePresentation.showBeveragesMenu();
                choice = input.nextInt();
                beveragePresentation.chooseChoice(choice);
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please provide a number(1,2 or 3)");
        }
    }
}
