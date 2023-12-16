package com.example.template.repository;

import com.example.template.model.Customer;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CustomerRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Customer> findAll() {
        return getEntityManager().createNamedQuery("CUSTOMER.FIND_ALL", Customer.class).getResultList();
    }

    public Customer find(Integer customerNumber) {
        return getEntityManager().find(Customer.class, customerNumber);
    }

    public boolean insert(Customer customer) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(Customer customer) {
        if (customer != null) {
            EntityManager entityManager = getEntityManager();
            if (entityManager.contains(customer)) {
                entityManager.getTransaction().begin();
                entityManager.remove(customer);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return delete(customer.getCustomerNumber());
            }
        }
        return false;
    }

    public boolean delete(Integer customerNumber) {
        EntityManager entityManager = getEntityManager();
        Customer customer = find(customerNumber);
        if (customer != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(customer);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean update(Customer newCustomer) {
        EntityManager entityManager = getEntityManager();
        if (newCustomer != null) {
            try {
                Customer customer = find(newCustomer.getCustomerNumber());
                if (customer != null) {
                    entityManager.getTransaction().begin();
                    // Update the necessary fields
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
}
