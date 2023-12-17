package com.example.template.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "PRODUCT.FIND_ALL", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "PRODUCT.FIND_BY_DES", query = "SELECT p FROM Product  p WHERE p.productDescription LIKE :desParam")
})
public class Product {
    @Id
    private String productCode;
    private String productName;

    @ManyToOne
    @JoinColumn(name = "productLine", nullable = false)
    private ProductLine productLine;

    private String productScale;
    private String productVendor;
    @Column(columnDefinition = "TEXT")
    private String productDescription;
    private Short quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal MSRP;
}
