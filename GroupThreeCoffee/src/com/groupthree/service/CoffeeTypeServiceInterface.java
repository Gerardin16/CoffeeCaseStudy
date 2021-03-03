package com.groupthree.service;

import java.sql.SQLException;

public interface CoffeeTypeServiceInterface {
    ArrayList<CoffeeType> getCoffeeType()throws ClassNotFoundException, SQLException;
}
