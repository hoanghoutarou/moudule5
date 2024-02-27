package com.ra.module5version2.service.Product;

import com.ra.module5version2.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Boolean create(Product product);
    Product findById(Long id);
    Boolean update(Product product);
    Boolean delete(Long id);
}
