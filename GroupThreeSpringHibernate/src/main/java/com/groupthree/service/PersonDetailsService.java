package com.groupthree.service;
import com.groupthree.bean.PersonDetails;
import com.groupthree.dao.PersonDetailsDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupthree.dao.PersonDetailsDaoInterface;

@Service
public class PersonDetailsService implements PersonDetailsServiceInterface{
	@Autowired
	private PersonDetailsDao personDetailsDao;

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
