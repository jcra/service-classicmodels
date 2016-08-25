package org.classicmodels.repositories;

import org.classicmodels.model.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByCustomerNumber_CustomerNumber(Long customerNumber);
}
