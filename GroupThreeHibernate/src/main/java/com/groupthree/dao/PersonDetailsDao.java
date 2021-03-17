package com.groupthree.dao;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
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

import com.groupthree.bean.PersonDetails;



public class PersonDetailsDao implements PersonDetailsDaoInterface{
	
		@Override
		public ArrayList<PersonDetails> searchRecordByPhoneno(long person_phoneno) throws ClassNotFoundException, SQLException {
//			
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			
			Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

			//For entire application one SessionFactory object : SessionFactory is SingleTon
			SessionFactory factory=meta.getSessionFactoryBuilder().build();
			
			//For every Transaction one Session object
			Session session=factory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			
			Query<PersonDetails> query = session.createQuery("from PersonDetails where personPhoneNo=:pnum" );
			query.setParameter("pnum", person_phoneno) ;       
			List<PersonDetails> person=query.getResultList();
			transaction.commit();
			session.close();
			return   (ArrayList<PersonDetails>) person;
}

		public PersonDetails insertPerson(String name, long personPhoneno) throws ClassNotFoundException, SQLException {
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			
			Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

			//For entire application one SessionFactory object : SessionFactory is SingleTon
			SessionFactory factory=meta.getSessionFactoryBuilder().build();
			
			//For every Transaction one Session object
			Session session=factory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			PersonDetails person=new PersonDetails(name,personPhoneno);
			
			session.save(person);
			transaction.commit();
			session.close();
			factory.close();
			return person;
		}
}