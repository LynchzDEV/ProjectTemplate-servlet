package com.example.template.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "employees")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "EMPLOYEE.FIND_ALL", query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "EMPLOYEE.FIND_BY_NAME", query = "SELECT e FROM Employee e WHERE e.firstName LIKE :nameParam OR e.lastName LIKE :nameParam"),
        @NamedQuery(name = "EMPLOYEE.USERNAME_CHECKER", query = "SELECT COUNT(e) FROM Employee e WHERE e.firstName = :nameParam"),
        @NamedQuery(name = "EMPLOYEE.ID_CHECKER", query = "SELECT COUNT(e) FROM Employee e WHERE e.id = :idParam"),
        @NamedQuery(name = "EMPLOYEE.COMBINED_CHECKER", query = "SELECT COUNT(e) FROM Employee e WHERE e.id = :idParam AND e.firstName = :nameParam"),
        @NamedQuery(name = "EMPLOYEE.UNIQUE_JOB_TITLES", query = "SELECT DISTINCT e.jobTitle FROM Employee e")
})
public class Employee {
    @Id
    @Column(name = "employeeNumber", nullable = false, unique = true)
    private Integer id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String firstName;
    private String lastName;
    private String extension;
    private String email;
    private String officeCode;
    private Integer reportsTo;
    private String jobTitle;
    @ManyToOne
    @JoinColumn(name = "officeCode", nullable = false, insertable = false, updatable = false)
    private Office office;
}