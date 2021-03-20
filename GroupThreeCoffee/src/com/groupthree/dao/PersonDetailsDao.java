package com.groupthree.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.groupthree.bean.CoffeeOrder;
import com.groupthree.bean.PersonDetails;
import com.groupthree.util.OracleConnectionManagement;

public class PersonDetailsDao implements PersonDetailsDaoInterface{
	
		@Override
		public PersonDetails searchRecordByPhoneno(long person_phoneno) throws ClassNotFoundException, SQLException {
			Connection connection = null;
			PersonDetails personDetails  = null;

			connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wiley123");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM PERSON WHERE PERSON_PHONENO="+person_phoneno);
//			statement.setLong(1, person_phoneno);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				 personDetails= new PersonDetails();
				personDetails.setpId(resultSet.getInt("PID"));
				personDetails.setPersonName(resultSet.getString("PERSON_NAME"));
				personDetails.setPersonPhoneNo(resultSet.getLong("PERSON_PHONENO"));
			}
			connection.close();
			return personDetails;
}

		public PersonDetails insertPerson(String name, long personPhoneno) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			 Connection connection = null;
	         PersonDetails person=new PersonDetails();

	        connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wiley123");

	     
	        String query="insert into PERSON(PERSON_NAME,PERSON_PHONENO) values (?,?)";
	      	
	        PreparedStatement insertStatement=connection.prepareStatement(query );
	        person.setPersonName(name);
	       person.setPersonPhoneNo(personPhoneno);
	       
//	        need to change below value
	        insertStatement.setString(1, person.getPersonName());
	        insertStatement.setLong(2, person.getPersonPhoneNo());
	       
	        insertStatement.executeUpdate();
	        PreparedStatement statement = connection.prepareStatement("SELECT * FROM PERSON WHERE PERSON_PHONENO="+personPhoneno);
//			statement.setLong(1, person_phoneno);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				person.setpId(resultSet.getInt("PID"));
				person.setPersonName(resultSet.getString("PERSON_NAME"));
				person.setPersonPhoneNo(resultSet.getLong("PERSON_PHONENO"));
			}
			connection.close();
	        return person;
		
		}
}