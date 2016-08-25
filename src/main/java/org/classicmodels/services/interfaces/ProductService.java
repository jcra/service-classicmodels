package org.classicmodels.services.interfaces;

import org.classicmodels.model.entities.ProductLines;
import org.classicmodels.model.entities.Products;

import java.util.List;

public interface ProductService {

    Products save(Products products) throws Exception;

    List<Products> getAll() throws Exception;

    Products getProduct(String productCode) throws Exception;

    List<Products> getProductByProductLine(String productLine) throws Exception;

    ProductLines saveProductLines(ProductLines productLines) throws Exception;

    List<ProductLines> getAllProductLines() throws Exception;

    ProductLines getProductLine(String productLine) throws Exception;
}
