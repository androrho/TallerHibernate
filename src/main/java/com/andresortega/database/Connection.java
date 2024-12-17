/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andresortega.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.tool.schema.Action;

/**
 *
 * @author Andrés
 */
public class Connection{

    static SessionFactory sf;

    public Connection() {
        createSessionFactory();
    }
    
    
    private static void createSessionFactory() {
        sf = new org.hibernate.cfg.Configuration()
                // Entity 
                // .addAnnotatedClass(Book.class)
                // .addAnnotatedClass(Author.class)
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

    public static Session getSession() {
        return sf.getCurrentSession();
    }
    
    public static Session openSesion(){
        return sf.openSession();
    }
    

}
