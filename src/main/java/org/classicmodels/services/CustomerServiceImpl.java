package org.classicmodels.services;

import org.classicmodels.exceptions.ServiceException;
import org.classicmodels.exceptions.UserCausedException;
import org.classicmodels.model.entities.Customers;
import org.classicmodels.repositories.CustomerRepository;
import org.classicmodels.services.interfaces.CustomerService;
import org.classicmodels.util.commons.Messages;
import org.classicmodels.util.commons.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    @Override
    public Customers save(Customers customer) throws Exception{

        try{

            if(customer == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "customer");
            customerRepository.save(customer);
            return customer;

        }catch(DataIntegrityViolationException e){
            throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, e.getMostSpecificCause().getMessage(), e);
        }catch (UserCausedException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }


    }

    @Override
    public List<Customers> getAll() throws Exception {
        try{

            return customerRepository.findAll();

        }catch(Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public Customers getCustomer(Long customerNumber) throws Exception {

        try{

            if(customerNumber == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "customerNumber");

            Customers out = customerRepository.findOne(customerNumber);

            if(out == null) throw new UserCausedException(ReturnCode.ERR_RECORD_NOT_FOUND, Messages.ERR_RECORD_NOT_FOUND, "customerNumber", customerNumber);

            return out;

        }catch (UserCausedException e){
            throw e;
        }catch(Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public List<Customers> getCustomersByEmployee(Long employeeNumber) throws Exception{

        try{

            if(employeeNumber == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "employeeNumber");

            List<Customers> out = customerRepository.findCustomersBySalesRepEmployeeNumber_EmployeeNumber(employeeNumber);

            if(out.size() == 0) throw new UserCausedException(ReturnCode.ERR_RECORD_NOT_FOUND, Messages.ERR_RECORD_NOT_FOUND, "employeeNumber", employeeNumber);

            return out;

        }catch (UserCausedException e){
            throw e;
        }catch(Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }
}
