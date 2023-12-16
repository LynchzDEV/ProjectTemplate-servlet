package com.example.template.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productlines")
@Getter
@Setter
public class ProductLine {
    @Id
    private String productLine;
    private String textDescription;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String htmlDescription;
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] image;
}
