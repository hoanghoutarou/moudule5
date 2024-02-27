package com.ra.module5version2.service.Category;

import com.ra.module5version2.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Boolean create(Category category);
    Category findById(Long id);
    Boolean update(Category category);
    Boolean delete(Long id);
}
