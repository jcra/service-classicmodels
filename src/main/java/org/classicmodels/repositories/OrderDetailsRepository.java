package org.classicmodels.repositories;

import org.classicmodels.model.entities.OrderDetails;
import org.classicmodels.model.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Orders>{

    List<OrderDetails> findByOrderNumber_OrderNumberOrderByOrderLineNumberAsc(Long orderNumber);
}
