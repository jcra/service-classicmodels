package org.classicmodels.services.interfaces;


import org.classicmodels.model.entities.Employees;

import java.util.List;

public interface EmployeeService {

    Employees save(Employees employees) throws Exception;

    List<Employees> getAll() throws Exception;

    Employees getEmployee(Long employeeNumber) throws Exception;

    List<Employees> getEmployeesByOffice(Long officeCode) throws Exception;

    List<Employees> getEmployeesByManager(Long managerNumber) throws Exception;
}
