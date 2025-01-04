package com.andresortega.database;

import com.andresortega.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

public static void update(Customer object) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.merge(object);
    tx.commit();
    em.close();
}

public static Customer getCustomer(Integer id) {
    return load(id);
}

public static String getDni(Integer id) {
    Customer customer = findById(id);
    if (customer != null) {
        return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"customer\",\n      \"dni\": \"" + customer.getDni() + "\",\n      \"query\":\"success\"\n   }\n]";
    }
    return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"customer\",\n      \"query\":\"failed\"\n   }\n]";
}

public static String getName(Integer id) {
    Customer customer = findById(id);
    if (customer != null) {
        return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"customer\",\n      \"name\": \"" + customer.getName() + "\",\n      \"query\":\"success\"\n   }\n]";
    }
    return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"customer\",\n      \"query\":\"failed\"\n   }\n]";
}

public static String getAge(Integer id) {
    Customer customer = findById(id);
    if (customer != null) {
        return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"customer\",\n      \"age\": \"" + customer.getAge() + "\",\n      \"query\":\"success\"\n   }\n]";
    }
    return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"customer\",\n      \"query\":\"failed\"\n   }\n]";
}

public static Customer findById(Integer id) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    Customer object = em.find(Customer.class, id);
    tx.commit();
    em.close();
    return object;
}

public static Customer load(Integer id) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    Customer objectResult = em.find(Customer.class, id);
    tx.commit();
    em.close();
    return objectResult;
}

public static Customer load(Customer object) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    Customer objectResult = em.find(Customer.class, object.getCustomerId());
    tx.commit();
    em.close();
    return objectResult;
}

public static void deleteById(Integer id) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.remove(em.find(Customer.class, id));
    tx.commit();
    em.close();
}

public static void delete(Customer object) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.remove(em.find(Object.class, object.getCustomerId()));
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
