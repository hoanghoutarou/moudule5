package com.ra.module5version2.service.Product;

import com.ra.module5version2.model.entity.Product;
import com.ra.module5version2.reporsitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Boolean create(Product product) {
        try {
            product.setSku(UUID.randomUUID().toString());
            product.setCreated(new java.sql.Date(new java.util.Date().getTime()));
            this.productRepository.save(product);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public Boolean update(Product product) {
        try {
            this.productRepository.save(product);
            product.setUpdated(new java.sql.Date(new java.util.Date().getTime()));
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        try{
            this.productRepository.delete(findById(id));
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public List<Product> getByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }
}
