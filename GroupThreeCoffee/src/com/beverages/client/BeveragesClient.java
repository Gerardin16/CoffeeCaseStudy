package com.beverages.client;

import com.groupthree.presentation.BeveragePresentationImpl;
import com.groupthree.presentation.BeveragePresentationInterface;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BeveragesClient {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        BeveragePresentationInterface beveragePresentation = new BeveragePresentationImpl();


            while (true) {
                beveragePresentation.showBeveragesMenu();
            }

    }
}
