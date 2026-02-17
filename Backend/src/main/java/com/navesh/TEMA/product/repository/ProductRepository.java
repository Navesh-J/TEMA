package com.navesh.TEMA.product.repository;

import com.navesh.TEMA.common.entity.Product;
import com.navesh.TEMA.common.entity.User;
import com.navesh.TEMA.common.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByVendor(User vendor);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategory(Category category);
}
