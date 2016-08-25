package org.classicmodels.resources;

import org.classicmodels.model.entities.Customers;
import org.classicmodels.model.views.Customer;
import org.classicmodels.services.interfaces.CustomerService;
import org.classicmodels.services.interfaces.EmployeeService;
import org.classicmodels.util.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("customers")
public class CustomerResource extends BaseResource {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;


    @POST
    @Path("customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Customer customer){

        try{

            Customers insertedCustomer = EntityMapper.INSTANCE.toCustomers(customer);

            insertedCustomer.setSalesRepEmployeeNumber(employeeService.getEmployee(customer.getSalesRepEmployeeNumber()));

            customerService.save(insertedCustomer);

            customer = EntityMapper.INSTANCE.toCustomerView(insertedCustomer);

            return Response.status(Response.Status.OK).entity(customer).build();

        }catch (Exception e){
            return onException(e);
        }
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll(){

        try {

            List<Customers> in =  customerService.getAll();

            List<Customer> out = EntityMapper.INSTANCE.toCustomerViewList(in);

            GenericEntity entity = new GenericEntity<List<Customer>>(out){};

            return  Response.status(Response.Status.OK).entity(entity).build();

        }catch (Exception e){
            return onException(e);
        }
    }

    @GET
    @Path("customer/{customerNumber}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCustomer(@PathParam("customerNumber") Long customerNumber){

        try{

            Customers in = customerService.getCustomer(customerNumber);

            Customer out = EntityMapper.INSTANCE.toCustomerView(in);

            return Response.status(Response.Status.OK).entity(out).build();

        }catch(Exception e){
            return onException(e);
        }
    }

    @GET
    @Path("employee/{employeeNumber}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCustomersByEmployee(@PathParam("employeeNumber") Long employeeNumber){

        try{

            List<Customers> in = customerService.getCustomersByEmployee(employeeNumber);

            List<Customer> out = EntityMapper.INSTANCE.toCustomerViewList(in);

            GenericEntity entity = new GenericEntity<List<Customer>>(out){};

            return Response.status(Response.Status.OK).entity(entity).build();

        }catch(Exception e){
            return onException(e);
        }
    }
}
