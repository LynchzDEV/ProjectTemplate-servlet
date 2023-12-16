package com.example.template.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
@NamedQueries({
        @NamedQuery(name = "CUSTOMER.FIND_USER", query = "SELECT c FROM Customer c WHERE concat(trim(c.contactFirstName),' ', trim(c.contactLastName)) = :user_account")
})
public class Customer {
    @Id
    private Integer customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber")
    private Employee salesRepEmployee;

    private double creditLimit;
    private String password; // Ensure to handle passwords securely
}
