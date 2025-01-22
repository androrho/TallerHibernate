package com.andresortega.orm.controller;

import com.andresortega.orm.model.Car;
import com.andresortega.orm.model.Repair;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.RollbackException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés
 */
public class RepairService {

    public static void create(Repair object) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(object);
            tx.commit();
            em.close();
        } catch (RollbackException e) {
            tx.rollback();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public static List<Repair> read() {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Repair> list = new ArrayList();

        try {
            tx.begin();
            String hql = "SELECT r FROM Repair r";
            list = em.createQuery(hql, Repair.class)
                    .getResultList();
            tx.commit();
        } catch (NoResultException e) {
            System.out.println("No hay reparaciones");
            tx.rollback();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return list;
    }

    public static Repair read(Integer id) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Repair objectResult = em.find(Repair.class, id);
        tx.commit();
        em.close();
        return objectResult;
    }

    public static void update(Repair object) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(object);
            tx.commit();
            em.close();
        } catch (RollbackException e) {
            tx.rollback();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Integer id) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.find(Repair.class, id));
        tx.commit();
        em.close();
    }

    public static List<Repair> findByCar(Car car) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Repair> list = new ArrayList();

        try {
            tx.begin();
            String hql = "SELECT r FROM Repair r WHERE r.car = :car";
            list = em.createQuery(hql, Repair.class)
                    .setParameter("car", car)
                    .getResultList();
            tx.commit();
        } catch (NoResultException e) {
            System.out.println("Ese coche no ha tenido reparaciones");
            tx.rollback();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return list;
    }
    
    public static boolean carHasToBePickedUp(Repair r){
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Integer count = null;
        
        try {
            tx.begin();
            String sql = "SELECT COUNT(*) FROM Repairs WHERE carId = :carId and customerId = :customerId AND repairState = 3";
            count = (Integer) em.createNativeQuery(sql, Integer.class)
                    .setParameter("carId", r.getCar().getCarId())
                    .setParameter("customerId", r.getCustomer().getCustomerId())
                    .getSingleResult();
            tx.commit();
        } catch (NoResultException e) {
            tx.rollback();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        
        if (count >= 1){
            System.out.println("Tienes coche(s) para recoger, recógelos primero antes de reparar otro.");
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean carIsInGarage(Repair r){
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Integer count = null;
        
        try {
            tx.begin();
            String sql = "SELECT COUNT(*) FROM Repairs WHERE carId = :carId and customerId != :customerId AND repairState != 4";
            count = (Integer) em.createNativeQuery(sql, Integer.class)
                    .setParameter("carId", r.getCar().getCarId())
                    .setParameter("customerId", r.getCustomer().getCustomerId())
                    .getSingleResult();
            tx.commit();
        } catch (NoResultException e) {
            tx.rollback();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        
        if (count >= 1){
            System.out.println("El coche está en el taller por reparaciones de otro cliente.");
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean repairIsPickedUp(Repair r){
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Integer count = null;
        
        try {
            tx.begin();
            String sql = "SELECT COUNT(*) FROM Repairs WHERE repairId = :repairId AND repairState = 4";
            count = (Integer) em.createNativeQuery(sql, Integer.class)
                    .setParameter("repairId", r.getRepairId())
                    .getSingleResult();
            tx.commit();
        } catch (NoResultException e) {
            tx.rollback();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        
        if (count >= 1){
            System.out.println("El coche ya no está en el taller.");
            return true;
        } else {
            return false;
        }
    }
}
