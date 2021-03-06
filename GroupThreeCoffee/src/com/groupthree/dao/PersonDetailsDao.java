package com.groupthree.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.groupthree.bean.PersonDetails;
import com.groupthree.util.OracleConnectionManagement;

public class PersonDetailsDao implements PersonDetailsDaoInterface{
	
		@Override
		public PersonDetails searchRecordByPhoneno(long person_phoneno) throws ClassNotFoundException, SQLException {
			Connection connection = null;
			PersonDetails personDetails  = null;

			connection = OracleConnectionManagement.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "wiley123");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM PERSON WHERE PERSON_PHONENO=?");
			statement.setLong(1, person_phoneno);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				PersonDetails personDetails1= new PersonDetails();
				personDetails1.setpId(resultSet.getInt("PID"));
				personDetails1.setPersonName(resultSet.getString("PERSON_NAME"));
				personDetails1.setPersonPhoneNo(resultSet.getLong("PERSON_PHONENO"));
			}
			connection.close();
			return personDetails;
}

		@Override
		public ArrayList<PersonDetails> getPersonDetails() throws ClassNotFoundException, SQLException {
			
			return null;
		}
}