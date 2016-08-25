package org.classicmodels.services.interfaces;

import org.classicmodels.model.entities.Customers;

import java.util.List;

public interface CustomerService {

    Customers save(Customers customer) throws Exception;

    List<Customers> getAll() throws Exception;

    Customers getCustomer(Long customerNumber) throws Exception;

    List<Customers> getCustomersByEmployee(Long employeeNumber) throws Exception;
}
