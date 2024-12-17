/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.andresortega.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;



/**
 *
 * @author Andrés
 */
public class ORM {

    public static void main(String[] args) {
        SessionFactory sf = new org.hibernate.cfg.Configuration()
                // Entity 
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Repair.class)
                // MySQL
                .setProperty(AvailableSettings.JAKARTA_JDBC_URL,
                        new org.hibernate.cfg.Configuration().getProperty("jakarta.persistence.jdbc.url"))
                // Credentials
                .setProperty(AvailableSettings.JAKARTA_JDBC_USER,
                        new org.hibernate.cfg.Configuration().getProperty("jakarta.persistence.jdbc.user"))
                .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD,
                        new org.hibernate.cfg.Configuration().getProperty("jakarta.persistence.jdbc.password"))
                // Automatic schema export
                .setProperty(AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION,
                        new org.hibernate.cfg.Configuration().getProperty("jakarta.persistence.schema-generation.database.action"))
                // SQL statement logging
                // .setProperty(AvailableSettings.SHOW_SQL, true)
                // .setProperty(AvailableSettings.FORMAT_SQL, true)
                // .setProperty(AvailableSettings.HIGHLIGHT_SQL, true)
                // Create a new SessionFactory
                .buildSessionFactory();
        
        Session s = sf.openSession();
        
        s.beginTransaction();
        
        Customer c = new Customer();
        
        c.dni = "71313042R";
        c.name = "Pepe";
        c.age = 20;
        
        s.persist(c);
        s.getTransaction().commit();
        s.close();
        sf.close();
        
    }
    
    
}
