package com.groupthree.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.groupthree.bean.PersonDetails;

public interface PersonDetailsDaoInterface {

	 ArrayList<PersonDetails> getPersonDetails() throws ClassNotFoundException, SQLException;
	 PersonDetails searchRecordByPhoneno(long person_phoneno)throws ClassNotFoundException,SQLException;
}