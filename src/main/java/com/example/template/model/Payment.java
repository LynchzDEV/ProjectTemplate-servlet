package com.example.template.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    private Integer customerNumber;
    @Id
    private String checkNumber;
    private Date paymentDate;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "customerNumber", nullable = false, insertable = false, updatable = false)
    private Customer customer;
}
