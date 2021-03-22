package com.groupthree.service;
import com.groupthree.bean.PersonDetails;
import com.groupthree.dao.PersonDetailsDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.groupthree.dao.PersonDetailsDaoInterface;


public class PersonDetailsService implements PersonDetailsServiceInterface{
	private PersonDetailsDao personDetailsDao=new PersonDetailsDao();

@Override
public ArrayList<PersonDetails> searchRecordByPhoneno(long person_phoneno)  {
	ArrayList<PersonDetails> personDetails= personDetailsDao.searchRecordByPhoneno(person_phoneno);
				
//	if(personDetails!=null) {
//	personDetails.setpId(personDetails.getpId());
//	personDetails.setPersonName(personDetails.getPersonName());
//	personDetails.setPersonPhoneNo(personDetails.getPersonPhoneNo());
	
//}
	return personDetails;
}

@Override
public PersonDetails insertPerson(String name,long personPhoneno) {
	// TODO Auto-generated method stub
	return  personDetailsDao.insertPerson(name, personPhoneno);
}





}
