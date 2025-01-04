package com.andresortega.database;

import com.andresortega.model.Car;
import com.andresortega.model.Customer;
import com.andresortega.model.Repair;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author Andrés
 */
public class RepairService {
    public static void create(Repair object) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.persist(object);
    tx.commit();
    em.close();
}

public static void update(Repair object) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.merge(object);
    tx.commit();
    em.close();
}

public static Repair getRepair(Integer id) {
    return load(id);
}

public static String getCar(Integer id) {
    Repair repair = findById(id);
    if (repair != null) {
        return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"repair\",\n      \"car\": \"" + repair.getCar() + "\",\n      \"query\":\"success\"\n   }\n]";
    }
    return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"repair\",\n      \"query\":\"failed\"\n   }\n]";
}

public static String getCustomer(Integer id) {
    Repair repair = findById(id);
    if (repair != null) {
        return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"repair\",\n      \"car\": \"" + repair.getCustomer() + "\",\n      \"query\":\"success\"\n   }\n]";
    }
    return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"repair\",\n      \"query\":\"failed\"\n   }\n]";
}

public static String getPrice(Integer id) {
    Repair repair = findById(id);
    if (repair != null) {
        return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"repair\",\n      \"car\": \"" + repair.getPrice() + "\",\n      \"query\":\"success\"\n   }\n]";
    }
    return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"repair\",\n      \"query\":\"failed\"\n   }\n]";
}

public static String getDate(Integer id) {
    Repair repair = findById(id);
    if (repair != null) {
        return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"repair\",\n      \"car\": \"" + repair.getDate() + "\",\n      \"query\":\"success\"\n   }\n]";
    }
    return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"repair\",\n      \"query\":\"failed\"\n   }\n]";
}

public static String getDescription(Integer id) {
    Repair repair = findById(id);
    if (repair != null) {
        return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"repair\",\n      \"car\": \"" + repair.getDescription() + "\",\n      \"query\":\"success\"\n   }\n]";
    }
    return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"repair\",\n      \"query\":\"failed\"\n   }\n]";
}



public static Repair findById(Integer id) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    Repair object = em.find(Repair.class, id);
    tx.commit();
    em.close();
    return object;
}

public static Repair load(Integer id) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    Repair objectResult = em.find(Repair.class, id);
    tx.commit();
    em.close();
    return objectResult;
}

public static Repair load(Repair object) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    Repair objectResult = em.find(Repair.class, object.getRepairId());
    tx.commit();
    em.close();
    return objectResult;
}

public static void deleteById(Integer id) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.remove(em.find(Repair.class, id));
    tx.commit();
    em.close();
}

public static void delete(Repair object) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.remove(em.find(Object.class, object.getRepairId()));
    tx.commit();
    em.close();
}

public static List<Repair> findByCustomer(Customer customer) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    List<Repair> list = em.createQuery("SELECT c FROM Car c WHERE c.name LIKE :name").setParameter("name", "%" + customer.getCustomerId() + "%").getResultList();
    tx.commit();
    em.close();
    return list;
}

public static List<Repair> findByCar(Car car) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    List<Repair> list = em.createQuery("SELECT c FROM Car c WHERE c.name LIKE :name").setParameter("name", "%" + car.getCarId() + "%").getResultList();
    tx.commit();
    em.close();
    return list;
}

}