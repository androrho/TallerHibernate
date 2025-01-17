package com.andresortega.controller;

import com.andresortega.model.Car;
import com.andresortega.model.Customer;
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

    public static String getName(String dni) {
        Customer customer = CustomerService.read(dni);
        if (customer != null) {
            return "[\n   {\n      \"dni\":" + dni + ",\n      \"type\":\"customer\",\n      \"name\": \"" + customer.getName() + "\",\n      \"query\":\"success\"\n   }\n]";
        }
        return "[\n   {\n      \"dni\":" + dni + ",\n      \"type\":\"customer\",\n      \"query\":\"failed\"\n   }\n]";
    }

    public static String getAge(String dni) {
        Customer customer = CustomerService.read(dni);
        if (customer != null) {
            return "[\n   {\n      \"dni\":" + dni + ",\n      \"type\":\"customer\",\n      \"age\": \"" + customer.getAge() + "\",\n      \"query\":\"success\"\n   }\n]";
        }
        return "[\n   {\n      \"dni\":" + dni + ",\n      \"type\":\"customer\",\n      \"query\":\"failed\"\n   }\n]";
    }

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

    public static boolean delete(String dni) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean deleted = false;
        
        try {
            tx.begin();
        String hql = "DELETE FROM Customer c WHERE c.dni = :dni";
        int rowsAffected = em.createQuery(hql)
                .setParameter("dni", dni)
                .executeUpdate();
        tx.commit();
        deleted = rowsAffected > 0;
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        
        return deleted;
    }

    public static void delete(Customer object) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.find(Object.class, object.getDni()));
        tx.commit();
        em.close();
    }

    /* ACTUALMENTE NO SIRVE PERO LO DEJO
public static List<Car> findByName(String name) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    List<Car> list = em.createQuery("SELECT c FROM Car c WHERE c.name LIKE :name").setParameter("name", "%" + name + "%").getResultList();
    tx.commit();
    em.close();
    return list;
}
     */
}
