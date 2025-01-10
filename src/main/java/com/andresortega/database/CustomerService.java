package com.andresortega.database;

import com.andresortega.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

    public static Customer read(String dni) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String hql = "SELECT c FROM Customer c WHERE c.dni = :dni";
        Customer object = em.createQuery(hql, Customer.class)
                .setParameter("dni", dni)
                .getSingleResult();
        tx.commit();
        em.close();
        return object;
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

    public static void delete(String dni) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String hql = "DELETE FROM Customer c WHERE c.dni = :dni";
        em.createQuery(hql)
                .setParameter("dni", dni)
                .executeUpdate();
        tx.commit();
        em.close();
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
