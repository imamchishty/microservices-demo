package com.demo.product.domain.repository;

import com.demo.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author imamchishty
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByManufacturer(String manufacturer);

    List<Product> findByName(String name);

    Product findByShortCode(String code);

}
