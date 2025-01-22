package com.andresortega.orm.controller;

import com.andresortega.orm.model.Car;
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
    
}
