package com.groupthree.dao;

import com.groupthree.bean.CoffeeSize;
import com.groupthree.bean.CoffeeType;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class CoffeeSizeDao implements CoffeeSizeDaoInterface {

StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	
	Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

	//For entire application one SessionFactory object : SessionFactory is SingleTon
	SessionFactory factory=meta.getSessionFactoryBuilder().build();
	
    @Override
    public ArrayList<CoffeeSize> getCoffeeSize()  {
 
		
		//For every Transaction one Session object
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		
		Query<CoffeeSize> query = session.createQuery("from CoffeeSize");
		       
		List<CoffeeSize>coffeeSizes=query.getResultList();
		transaction.commit();
		session.close();
		return  (ArrayList<CoffeeSize>) coffeeSizes;

    }
}




