package com.andresortega.database;

import com.andresortega.model.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés
 */
public class CarService {

    public static String getBrand(String licensePlate) {
        Car car = CarService.read(licensePlate);
        if (car != null) {
            return "[\n   {\n      \"licensePlate\":" + licensePlate + ",\n      \"type\":\"car\",\n      \"brand\": \"" + car.getBrand() + "\",\n      \"query\":\"success\"\n   }\n]";
        }
        return "[\n   {\n      \"licensePlate\":" + licensePlate + ",\n      \"type\":\"car\",\n      \"query\":\"failed\"\n   }\n]";
    }

    public static String getModel(String licensePlate) {
        Car car = CarService.read(licensePlate);
        if (car != null) {
            return "[\n   {\n      \"licensePlate\":" + licensePlate + ",\n      \"type\":\"car\",\n      \"model\": \"" + car.getModel() + "\",\n      \"query\":\"success\"\n   }\n]";
        }
        return "[\n   {\n      \"licensePlate\":" + licensePlate + ",\n      \"type\":\"car\",\n      \"query\":\"failed\"\n   }\n]";
    }

    public static String getEngineType(String licensePlate) {
        Car car = CarService.read(licensePlate);
        if (car != null) {
            return "[\n   {\n      \"licensePlate\":" + licensePlate + ",\n      \"type\":\"car\",\n      \"engineType\": \"" + car.getEngineType() + "\",\n      \"query\":\"success\"\n   }\n]";
        }
        return "[\n   {\n      \"licensePlate\":" + licensePlate + ",\n      \"type\":\"car\",\n      \"query\":\"failed\"\n   }\n]";
    }

    public static void create(Car object) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(object);
        tx.commit();
        em.close();
    }
    
    public static List<Car> read() {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Car> list = new ArrayList();

        try {
            tx.begin();
            String hql = "SELECT c FROM Car c";
            list = em.createQuery(hql, Car.class)
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

    public static Car read(String licensePlate) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Car car = null;

        try {
            tx.begin();
            String hql = "SELECT c FROM Car c WHERE c.licensePlate = :licensePlate";
            car = em.createQuery(hql, Car.class)
                    .setParameter("licensePlate", licensePlate)
                    .getSingleResult();
            tx.commit();
        } catch (NoResultException e) {
            System.out.println("No se encontró ningún coche con la matrícula: " + licensePlate);
            tx.rollback();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return car;
    }

    public static Car read(Car object) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Car objectResult = em.find(Car.class, object.getCarId());
        tx.commit();
        em.close();
        return objectResult;
    }

    public static void update(Car object) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(object);
        tx.commit();
        em.close();
    }

    public static boolean delete(String licensePlate) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean deleted = false;

        try {
            tx.begin();
            String hql = "DELETE FROM Car c WHERE c.licensePlate = :licensePlate";
            int rowsAffected = em.createQuery(hql)
                    .setParameter("licensePlate", licensePlate)
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
