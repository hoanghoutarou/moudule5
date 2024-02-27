package com.ra.module5version2.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(length = 100, unique = true)
    private String sku;

    @Column(name = "product_name", length = 100, unique = true)
    private String name;

    private String description;

    @Column(name = "unit_price")
    private Double price;

    @Column(name = "stock_quantity")
    @Min(0)
    private int quantity;

    private String image;

    @Column(name = "created_at")
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date created;

    @Column(name = "updated_at")
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date updated;
    @Column(name = "status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
}
