package com.example.template.repository;

import com.example.template.model.Employee;
import com.example.template.model.Office;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;

public class OfficeRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Office> findAll() {
        return getEntityManager().createNamedQuery("OFFICE.FIND_ALL").getResultList();
    }

    public Office findById(String id) {
        try {
            Query query = getEntityManager().createNamedQuery("OFFICE.FIND_BY_ID", Office.class);
            query.setParameter("idParam", id);
            return (Office) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public void clearEntityManagerCache() {
        EntityManager entityManager = getEntityManager();
        if (entityManager != null) {
            entityManager.clear();
        }
    }

    public boolean insert(Office office) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(office);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(Office office) {
        if (office != null) {
            EntityManager entityManager = getEntityManager();
            if (entityManager.contains(office)) {
                entityManager.getTransaction().begin();
                entityManager.remove(office);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return delete(office.getOfficeCode());
            }
        }
        return false;
    }


    public boolean delete(String officeCode) {
        EntityManager entityManager = getEntityManager();
        Office office = find(officeCode);
        if (office != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(office);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean update(Office newOffice) {
        EntityManager entityManager = getEntityManager();
        if (newOffice != null) {
            try {
                Office office = find(newOffice.getOfficeCode());
                if (office != null) {
                    entityManager.getTransaction().begin();
                    office.setCity(newOffice.getCity());
                    office.setPhone(newOffice.getPhone());
                    office.setAddressLine1(newOffice.getAddressLine1());
                    office.setAddressLine2(newOffice.getAddressLine2());
                    office.setState(newOffice.getState());
                    office.setCountry(newOffice.getCountry());
                    office.setPostalCode(newOffice.getPostalCode());
                    office.setTerritory(newOffice.getTerritory());
                    entityManager.getTransaction().commit();
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public List<Office> findByCityOrCountry(String cityOrCountry) {
        cityOrCountry = cityOrCountry.toLowerCase() + '%';
        Query query = getEntityManager().createNamedQuery("OFFICE.FIND_BY_CITY_OR_COUNTRY");
        query.setParameter("city", cityOrCountry);
        query.setParameter("country", cityOrCountry);
        return query.getResultList();
    }
}