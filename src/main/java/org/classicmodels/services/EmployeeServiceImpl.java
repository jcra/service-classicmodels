package org.classicmodels.services;

import org.classicmodels.exceptions.ServiceException;
import org.classicmodels.exceptions.UserCausedException;
import org.classicmodels.model.entities.Employees;
import org.classicmodels.repositories.EmployeeRepository;
import org.classicmodels.services.interfaces.EmployeeService;
import org.classicmodels.util.commons.Messages;
import org.classicmodels.util.commons.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.text.MessageFormat;
import java.util.List;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public Employees save(Employees employees) throws Exception{

        try{

            if(employees == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "employees");
            employeeRepository.save(employees);
            return employees;

        }catch(DataIntegrityViolationException e){
            throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, e.getMostSpecificCause().getMessage(), e);
        }catch (UserCausedException e){
            throw e;
        }catch(Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }

    }

    @Override
    public List<Employees> getAll() throws Exception{

        try{

            return employeeRepository.findAll();

        }catch(Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public Employees getEmployee(Long employeeNumber) throws Exception{

        try{

            if(employeeNumber == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "employeeNumber");

            Employees out = employeeRepository.findOne(employeeNumber);

            if(out == null) throw new UserCausedException(ReturnCode.ERR_RECORD_NOT_FOUND, Messages.ERR_RECORD_NOT_FOUND, "employeeNumber", employeeNumber);

            return out;

        }catch (UserCausedException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public List<Employees> getEmployeesByOffice(Long officeCode) throws Exception{

        try {

            if(officeCode == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "officeCode");

            List<Employees> out = employeeRepository.findByOfficeCode_OfficeCode(officeCode);

            if(out.size() == 0) throw new UserCausedException(ReturnCode.ERR_RECORD_NOT_FOUND, Messages.ERR_RECORD_NOT_FOUND, "officeCode", officeCode);

            return out;

        }catch (UserCausedException e){
            throw e;
        }catch(Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public List<Employees> getEmployeesByManager(Long managerNumber) throws Exception {

        try {

            if(managerNumber == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "managerNumber");

            List<Employees> out = employeeRepository.findByReportsTo_EmployeeNumber(managerNumber);

            if(out.size() == 0) throw new UserCausedException(ReturnCode.ERR_RECORD_NOT_FOUND, Messages.ERR_RECORD_NOT_FOUND, "managerNumber", managerNumber);

            return out;

        }catch (UserCausedException e){
            throw e;
        }catch(Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }
}
