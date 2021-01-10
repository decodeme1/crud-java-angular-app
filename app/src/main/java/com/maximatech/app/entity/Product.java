package com.maximatech.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String description;

    private BigDecimal price;

    private boolean enabled = false;

    @ManyToOne
    private Department department;

}
