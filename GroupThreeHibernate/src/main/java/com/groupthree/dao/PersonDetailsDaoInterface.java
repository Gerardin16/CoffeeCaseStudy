package com.groupthree.dao;

import java.sql.SQLException;

import com.groupthree.bean.PersonDetails;

public interface PersonDetailsDaoInterface {

     public PersonDetails insertPerson(String name, long personPhoneno) throws ClassNotFoundException, SQLException;
	 PersonDetails searchRecordByPhoneno(long person_phoneno)throws ClassNotFoundException,SQLException;
}