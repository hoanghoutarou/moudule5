package com.ra.module5version2.model.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private Double price;
    private int quantity;
    private String image;
    private Long categoryId;
}
