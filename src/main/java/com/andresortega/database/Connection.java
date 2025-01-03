/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andresortega.database;

import com.andresortega.model.Car;
import com.andresortega.model.Customer;
import com.andresortega.model.Repair;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;

/**
 *
 * @author Andrés
 */
public class Connection {
    
    public static SessionFactory createSessionFactory() {
        return new org.hibernate.cfg.Configuration()
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
    }
}
