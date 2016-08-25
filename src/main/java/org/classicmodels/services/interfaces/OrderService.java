package org.classicmodels.services.interfaces;

import org.classicmodels.model.entities.OrderDetails;
import org.classicmodels.model.entities.Orders;

import java.util.List;

public interface OrderService {

    Orders save(Orders order) throws Exception;

    List<Orders> getAll() throws Exception;

    Orders getOrder(Long orderNumber) throws Exception;

    List<Orders> getOrderByCustomer(Long customerNumber) throws Exception;

    List<OrderDetails> saveOrderDetails(List<OrderDetails> orderDetailsList) throws Exception;

    List<OrderDetails> getOrderDetails(Long orderNumber) throws Exception;






}
