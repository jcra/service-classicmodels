package org.classicmodels.services;

import org.classicmodels.exceptions.ServiceException;
import org.classicmodels.exceptions.UserCausedException;
import org.classicmodels.model.entities.OrderDetails;
import org.classicmodels.model.entities.Orders;
import org.classicmodels.repositories.OrderDetailsRepository;
import org.classicmodels.repositories.OrderRepository;
import org.classicmodels.services.interfaces.OrderService;
import org.classicmodels.util.commons.Messages;
import org.classicmodels.util.commons.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public Orders save(Orders order) throws Exception{

        try {

            if (order == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "order");
            orderRepository.save(order);
            return order;

        }catch (DataIntegrityViolationException e){
            throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, e.getMostSpecificCause().getMessage(), e);
        }catch (UserCausedException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public List<Orders> getAll() throws Exception{

        try{

            return orderRepository.findAll();

        }catch (Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public Orders getOrder(Long orderNumber) throws Exception{

        try {

            if(orderNumber == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "orderNumber");

            Orders out = orderRepository.findOne(orderNumber);

            if(out == null) throw new UserCausedException(ReturnCode.ERR_RECORD_NOT_FOUND, Messages.ERR_RECORD_NOT_FOUND, "orderNumber", orderNumber);

            return out;

        }catch (UserCausedException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public List<OrderDetails> getOrderDetails(Long orderNumber) throws Exception {

        try {

            if(orderNumber == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "orderNumber");

            List<OrderDetails> out = orderDetailsRepository.findByOrderNumber_OrderNumberOrderByOrderLineNumberAsc(orderNumber);

            if(out.size() == 0) throw new UserCausedException(ReturnCode.ERR_RECORD_NOT_FOUND, Messages.ERR_RECORD_NOT_FOUND, "orderNumber", orderNumber);

            return out;

        }catch (UserCausedException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public List<OrderDetails> saveOrderDetails(List<OrderDetails> orderDetailsList) throws Exception {

        try {

            if (orderDetailsList == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "orderDetailsList");
            orderDetailsRepository.save(orderDetailsList);
            return orderDetailsList;

        }catch (DataIntegrityViolationException e){
            throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, e.getMostSpecificCause().getMessage(), e);
        }catch (UserCausedException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public List<Orders> getOrderByCustomer(Long customerNumber) throws Exception {

        try{

            if(customerNumber == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "customerNumber");

            List<Orders> out = orderRepository.findByCustomerNumber_CustomerNumber(customerNumber);

            if(out.size() == 0) throw new UserCausedException(ReturnCode.ERR_RECORD_NOT_FOUND, Messages.ERR_RECORD_NOT_FOUND, "customerNumber", customerNumber);

            return out;

        }catch (UserCausedException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }
}
