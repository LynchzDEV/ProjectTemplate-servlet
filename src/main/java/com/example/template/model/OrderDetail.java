package com.example.template.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @Id
    private Integer orderNumber;
    @Id
    private String productCode;
    private Integer quantityOrdered;
    private BigDecimal priceEach;
    private Short orderLineNumber;

    @ManyToOne
    @JoinColumn(name = "orderNumber", nullable = false, insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productCode", nullable = false, insertable = false, updatable = false)
    private Product product;
}
