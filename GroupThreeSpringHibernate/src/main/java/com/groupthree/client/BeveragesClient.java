package com.groupthree.client;


import com.groupthree.presentation.BeveragePresentationInterface;


import java.sql.SQLException;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeveragesClient {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

      
    	AnnotationConfigApplicationContext springContainer=new AnnotationConfigApplicationContext(BeveragesConfig.class);
        BeveragePresentationInterface beveragePresentation =(BeveragePresentationInterface) 
        													springContainer.getBean("presentation");
		
            while (true) {
            	int selectedPerson=beveragePresentation.showPersonDetails();
                beveragePresentation.showBeveragesMenu(selectedPerson);
            }

    }
}
