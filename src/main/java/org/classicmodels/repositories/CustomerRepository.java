package org.classicmodels.repositories;

import org.classicmodels.model.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customers, Long>{

    List<Customers> findCustomersBySalesRepEmployeeNumber_EmployeeNumber(Long employeeNumber);
}
