package com.groupthree.service;

import java.sql.SQLException;

public interface CoffeeAddonServiceInterface {
    ArrayList<CoffeeAddon> getCoffeeAddon()throws ClassNotFoundException, SQLException;
}
