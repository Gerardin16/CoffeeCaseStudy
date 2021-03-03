package com.beverages.client;

import com.groupthree.presentation.BeveragePresentationImpl;
import com.groupthree.presentation.BeveragePresentationInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BeveragesClient {

    public static void main(String[] args) {

        BeveragePresentationInterface beveragePresentation = new BeveragePresentationImpl();


            while (true) {
                beveragePresentation.showBeveragesMenu();
            }

    }
}
