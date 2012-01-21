package com.cmpe276.hibernate;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	
    public SessionFactory sessionFactory;
    
    public HibernateUtil()
    {
    	
    }
    
    public SessionFactory ConnectDB(String cfgFile){
     
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure(cfgFile).buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return sessionFactory;
    }
        
}