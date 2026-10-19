package com.enterpret.ecommerce.repository;

import com.enterpret.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);

    @Query("SELECT p FROM Product p WHERE p.name ILIKE %:keyword% OR p.description ILIKE %:keyword%")
    List<Product> searchByKeyword(@Param("keyword") String keyword);

    boolean existsById(Long id);
}