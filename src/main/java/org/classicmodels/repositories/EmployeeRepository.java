package org.classicmodels.repositories;

import org.classicmodels.model.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {

    List<Employees> findByReportsTo_EmployeeNumber(Long reportsTo);

    List<Employees> findByOfficeCode_OfficeCode(Long officeCode);
}
