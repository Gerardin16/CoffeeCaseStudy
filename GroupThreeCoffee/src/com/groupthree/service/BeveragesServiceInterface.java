package com.groupthree.service;

import java.sql.SQLException;

public interface BeveragesServiceInterface {
    ArrayList<CoffeeType> getCoffeeType()throws ClassNotFoundException, SQLException;
}
