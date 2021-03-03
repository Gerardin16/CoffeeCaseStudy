package com.beverages.client;

import com.groupthree.presentation.BeveragePresentationImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BeveragesClient {

    public static void main(String[] args) {

        BeveragePresentationImpl beveragePresentation = new BeveragePresentationImpl();


            while (true) {
                beveragePresentation.showBeveragesMenu();
//                choice = input.nextInt();
//                beveragePresentation.chooseChoice(choice);
            }

    }
}
