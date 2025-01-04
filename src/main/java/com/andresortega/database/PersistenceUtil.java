/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andresortega.database;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
/**
 * @author Andrés
*/
public class PersistenceUtil {

    /*
    * Name of persistence unit which MUST correlate to persistence-unit name in persistence.xml
     */
    private static final String PERSISTENCE_UNIT_NAME = "org.hibernate.tutorial.jpa";

    private static final EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Throwable ex) {
            System.err.println("EntityManagerFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}
