package com.ra.module5version2.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Category {
    @Column(name = "category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,name = "category_name")
    private String name;
    @Column(name = "icon")
    private String icon;
    @Column(name = "created_at")
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date created;
    @Column(name = "status")
    private boolean status;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    List<Product> products;
}
