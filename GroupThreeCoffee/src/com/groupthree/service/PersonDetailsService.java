package com.groupthree.service;
import com.groupthree.bean.PersonDetails;
import com.groupthree.dao.PersonDetailsDao;
import java.sql.SQLException;
import java.util.ArrayList;

import com.groupthree.dao.PersonDetailsDaoInterface;


public class PersonDetailsService implements PersonDetailsServiceInterface{
	private PersonDetailsDao personDetailsDao=new PersonDetailsDao();

@Override
public PersonDetails searchRecordByPhoneno(long person_phoneno) throws ClassNotFoundException, SQLException {
	PersonDetails personDetails= personDetailsDao.searchRecordByPhoneno(person_phoneno);
				
	if(personDetails!=null) {
	personDetails.setpId(personDetails.getpId());
	personDetails.setPersonName(personDetails.getPersonName());
	personDetails.setPersonPhoneNo(personDetails.getPersonPhoneNo());
	
}
	return personDetails;
	}

@Override
public PersonDetails insertPerson(String name,long personPhoneno) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return  personDetailsDao.insertPerson(name, personPhoneno);
}





}
