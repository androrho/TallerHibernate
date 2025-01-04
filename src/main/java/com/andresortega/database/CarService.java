package com.andresortega.database;

import com.andresortega.model.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author Andrés
 */

public class CarService {



public static void create(Car object) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.persist(object);
    tx.commit();
    em.close();
}

public static void update(Car object) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.merge(object);
    tx.commit();
    em.close();
}

public static Car getCar(Integer id) {
    return load(id);
}

public static String getLicensePlate(Integer id) {
    Car car = findById(id);
    if (car != null) {
        return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"car\",\n      \"licensePlate\": \"" + car.getLicensePlate() + "\",\n      \"query\":\"success\"\n   }\n]";
    }
    return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"car\",\n      \"query\":\"failed\"\n   }\n]";
}

public static String getBrand(Integer id) {
    Car car = findById(id);
    if (car != null) {
        return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"car\",\n      \"brand\": \"" + car.getBrand() + "\",\n      \"query\":\"success\"\n   }\n]";
    }
    return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"car\",\n      \"query\":\"failed\"\n   }\n]";
}

public static String getModel(Integer id) {
    Car car = findById(id);
    if (car != null) {
        return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"car\",\n      \"model\": \"" + car.getModel() + "\",\n      \"query\":\"success\"\n   }\n]";
    }
    return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"car\",\n      \"query\":\"failed\"\n   }\n]";
}

public static String getEngineType(Integer id) {
    Car car = findById(id);
    if (car != null) {
        return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"car\",\n      \"engineType\": \"" + car.getEngineType() + "\",\n      \"query\":\"success\"\n   }\n]";
    }
    return "[\n   {\n      \"id\":"+id+",\n      \"type\":\"car\",\n      \"query\":\"failed\"\n   }\n]";
}

public static Car findById(Integer id) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    Car object = em.find(Car.class, id);
    tx.commit();
    em.close();
    return object;
}

public static Car load(Integer id) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    Car objectResult = em.find(Car.class, id);
    tx.commit();
    em.close();
    return objectResult;
}

public static Car load(Car object) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    Car objectResult = em.find(Car.class, object.getCarId());
    tx.commit();
    em.close();
    return objectResult;
}

public static void deleteById(Integer id) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.remove(em.find(Car.class, id));
    tx.commit();
    em.close();
}

public static void delete(Car object) {
    EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.remove(em.find(Object.class, object.getCarId()));
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
