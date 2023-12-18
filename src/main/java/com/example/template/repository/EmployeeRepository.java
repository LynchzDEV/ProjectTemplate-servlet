package com.example.template.repository;

import com.example.template.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class EmployeeRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Employee> findAll() {
        return getEntityManager().createNamedQuery("EMPLOYEE.FIND_ALL", Employee.class).getResultList();
    }

    public List<Employee> findByName(String name) {
        name = '%' + name.toLowerCase() + '%';
        Query query = getEntityManager().createNamedQuery("EMPLOYEE.FIND_BY_NAME", Employee.class);
        query.setParameter("nameParam", name);
        return query.getResultList();
    }

    public boolean usernameChecker(String username) {
        Query query = getEntityManager().createNamedQuery("EMPLOYEE.USERNAME_CHECKER", Long.class);
        query.setParameter("nameParam", username);
        long count = (long) query.getSingleResult();
        return count > 0;
    }

    public boolean idChecker(String password) {
        Query query = getEntityManager().createNamedQuery("EMPLOYEE.ID_CHECKER", Long.class);
        query.setParameter("idParam", password);
        long count = (long) query.getSingleResult();
        return count > 0;
    }

    public boolean combinedChecker(String employeeNumber, String firstName) {
        Query query = getEntityManager().createNamedQuery("EMPLOYEE.COMBINED_CHECKER", Long.class);
        query.setParameter("idParam", employeeNumber);
        query.setParameter("nameParam", firstName);
        long count = (long) query.getSingleResult();
        return count > 0;
    }

    public List<String> jobTitleList() {
        Query query = getEntityManager().createNamedQuery("EMPLOYEE.UNIQUE_JOB_TITLES", String.class);
        return query.getResultList();
    }

    public Employee find(Integer employeeNumber) {
        return getEntityManager().find(Employee.class, employeeNumber);
    }

    public boolean insert(Employee employee) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(Employee employee) {
        if (employee != null) {
            EntityManager entityManager = getEntityManager();
            if (entityManager.contains(employee)) {
                entityManager.getTransaction().begin();
                entityManager.remove(employee);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return delete(employee.getId());
            }
        }
        return false;
    }

    public boolean delete(Integer employeeNumber) {
        EntityManager entityManager = getEntityManager();
        Employee employee = find(employeeNumber);
        if (employee != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(employee);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean update(Employee newEmployee) {
        EntityManager entityManager = getEntityManager();
        if (newEmployee != null) {
            try {
                Employee employee = find(newEmployee.getId());
                if (employee != null) {
                    entityManager.getTransaction().begin();
                    employee.setFirstName(newEmployee.getFirstName());
                    employee.setLastName(newEmployee.getLastName());
                    employee.setExtension(newEmployee.getExtension());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setOfficeCode(newEmployee.getOfficeCode());
                    employee.setReportsTo(newEmployee.getReportsTo());
                    employee.setJobTitle(newEmployee.getJobTitle());
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
