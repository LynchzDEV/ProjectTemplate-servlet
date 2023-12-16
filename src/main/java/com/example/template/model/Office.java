package com.example.template.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "offices")
@NamedQueries({
        @NamedQuery(name = "EMPLOYEE.FIND_ALL", query = "SELECT o FROM Office o"),
})
public class Office {
    @Id
    @Column(name = "officeCode", nullable = false, unique = true)
    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;
}
