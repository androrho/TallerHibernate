package com.andresortega.orm.controller;

import com.andresortega.orm.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés
 */
public class CustomerService {

    public static void create(Customer object) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(object);
        tx.commit();
        em.close();
    }
    
    public static List<Customer> read() {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Customer> list = new ArrayList();

        try {
            tx.begin();
            String hql = "SELECT c FROM Customer c";
            list = em.createQuery(hql, Customer.class)
                    .getResultList();
            tx.commit();
        } catch (NoResultException e) {
            System.out.println("No se encontró ningún coche.");
            tx.rollback();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return list;
    }
    
    public static Customer read(String dni) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Customer customer = null;
        
        try {
            tx.begin();
            String hql = "SELECT c FROM Customer c WHERE c.dni = :dni";
            customer = em.createQuery(hql, Customer.class)
                    .setParameter("dni", dni)
                    .getSingleResult();
            tx.commit();
        } catch (NoResultException e) {
            System.out.println("No se encontró ningún cliente con el dni: " + dni);
            tx.rollback();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return customer;
    }

    public static Customer read(Customer object) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer objectResult = em.find(Customer.class, object.getCustomerId());
        tx.commit();
        em.close();
        return objectResult;
    }

    public static void update(Customer object) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(object);
        tx.commit();
        em.close();
    }
    
}
