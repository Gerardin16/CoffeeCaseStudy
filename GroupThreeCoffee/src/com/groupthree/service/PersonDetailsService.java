package com.groupthree.service;
import com.groupthree.bean.PersonDetails;
import com.groupthree.dao.PersonDetailsDao;
import java.sql.SQLException;
import java.util.ArrayList;

import com.groupthree.dao.PersonDetailsDaoInterface;

public class PersonDetailsService implements PersonDetailsServiceInterface{
	private PersonDetailsDao personDetailsDoa=new PersonDetailsDao();

@Override
public PersonDetails searchRecordByPhoneno(long person_phoneno) throws ClassNotFoundException, SQLException {
	PersonDetails personDetails= personDetailsDoa.searchRecordByPhoneno(person_phoneno);
				
	if(personDetails!=null) {
	personDetails.setpId(personDetails.getpId());
	personDetails.setPersonName(personDetails.getPersonName());
	personDetails.setPersonPhoneNo(personDetails.getPersonPhoneNo());
	
}
	return personDetails;
	}


@Override
public ArrayList<PersonDetails> getPersonDetails() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return null;
}	
}
