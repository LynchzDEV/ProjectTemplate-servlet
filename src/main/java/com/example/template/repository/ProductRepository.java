package com.example.template.repository;

import com.example.template.model.Product;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Product> findAll() {
        return getEntityManager().createNamedQuery("PRODUCT.FIND_ALL", Product.class).getResultList();
    }

    public Product find(String productCode) {
        return getEntityManager().find(Product.class, productCode);
    }

    public boolean insert(Product product) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(Product product) {
        if (product != null) {
            EntityManager entityManager = getEntityManager();
            if (entityManager.contains(product)) {
                entityManager.getTransaction().begin();
                entityManager.remove(product);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return delete(product.getProductCode());
            }
        }
        return false;
    }

    public boolean delete(String productCode) {
        EntityManager entityManager = getEntityManager();
        Product product = find(productCode);
        if (product != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(product);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean update(Product newProduct) {
        EntityManager entityManager = getEntityManager();
        if (newProduct != null) {
            try {
                Product product = find(newProduct.getProductCode());
                if (product != null) {
                    entityManager.getTransaction().begin();
                    // Set fields that need to be updated
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
