package com.groupthree.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.groupthree.bean.PersonDetails;
import com.groupthree.util.OracleConnectionManagement;

public class PersonDetailsService implements PersonDetailsServiceInterface{
	
		@Override
		public ArrayList<PersonDetails> getPersonDetails() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        ArrayList<PersonDetails> PersonDetails = new ArrayList<>();

        connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wiley123");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM PERSON");

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
        	
        	PersonDetails PersonDetails1= new PersonDetails();
        	PersonDetails1.setPid(resultSet.getInt("PID"));
        	PersonDetails1.setPersonName(resultSet.getString("PERSON_NAME"));
        	PersonDetails1.setPersonPhoneNo(resultSet.getLong("PERSON_PHONENO"));

        	PersonDetails.add(PersonDetails1);
         }
        connection.close();
        return PersonDetails ;

    }
}

