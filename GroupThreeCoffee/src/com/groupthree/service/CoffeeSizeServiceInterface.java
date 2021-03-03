package com.groupthree.service;

import java.sql.SQLException;

public interface CoffeeSizeServiceInterface {
    ArrayList<CoffeeSize> getCoffeeSize()throws ClassNotFoundException, SQLException;
}
