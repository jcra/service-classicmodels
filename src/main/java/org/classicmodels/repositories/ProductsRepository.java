package org.classicmodels.repositories;

import org.classicmodels.model.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, String>{

    List<Products> findByProductLine_ProductLine(String productLine);
}
