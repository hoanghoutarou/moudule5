package com.ra.module5version2.reporsitory;

import com.ra.module5version2.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
