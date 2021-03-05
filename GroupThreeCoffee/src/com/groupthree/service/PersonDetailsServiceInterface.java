package com.groupthree.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.groupthree.bean.PersonDetails;

public interface PersonDetailsServiceInterface {

	 ArrayList<PersonDetails> getPersonDetails() throws ClassNotFoundException, SQLException;
}
