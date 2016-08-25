package org.classicmodels.repositories;

import org.classicmodels.model.entities.ProductLines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLinesRepository extends JpaRepository<ProductLines, String>{}
