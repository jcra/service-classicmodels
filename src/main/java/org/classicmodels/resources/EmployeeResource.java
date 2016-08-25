package org.classicmodels.resources;

import org.classicmodels.model.entities.Employees;
import org.classicmodels.model.views.Employee;
import org.classicmodels.services.interfaces.EmployeeService;
import org.classicmodels.services.interfaces.OfficeService;
import org.classicmodels.util.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("employees")
public class EmployeeResource extends BaseResource {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OfficeService officeService;

    @POST
    @Path("employee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Employee employee){

        try{

            Employees insertedEmployee = EntityMapper.INSTANCE.toEmployees(employee);

            insertedEmployee.setOfficeCode(officeService.getOffice(employee.getOfficesCode()));

            insertedEmployee.setReportsTo(employeeService.getEmployee(employee.getReportsTo()));

            employeeService.save(insertedEmployee);

            employee = EntityMapper.INSTANCE.toEmployeeView(insertedEmployee);

            return Response.status(Response.Status.OK).entity(employee).build();

        }catch(Exception e){
            return onException(e);
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll(){

        try{

            List<Employees> in = employeeService.getAll();

            List<Employee> out = EntityMapper.INSTANCE.toEmployeeViewList(in);

            GenericEntity entity = new GenericEntity<List<Employee>>(out){};

            return Response.status(Response.Status.OK).entity(entity).build();
        }
        catch(Exception e){
            return onException(e);
        }
    }


    @GET
    @Path("employee/{employeeNumber}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getEmployee(@PathParam("employeeNumber") Long employeeNumber){

        try{

            Employees employees = employeeService.getEmployee(employeeNumber);

            Employee out = EntityMapper.INSTANCE.toEmployeeView(employees);

            return  Response.status(Response.Status.OK).entity(out).build();

        }catch (Exception e){
            return onException(e);
        }
    }

    @GET
    @Path("office/{officeCode}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getEmployeesByOffice(@PathParam("officeCode") Long officeCode){

        try{

            List<Employees> in = employeeService.getEmployeesByOffice(officeCode);

            List<Employee> out = EntityMapper.INSTANCE.toEmployeeViewList(in);

            GenericEntity entity = new GenericEntity<List<Employee>>(out){};

            return Response.status(Response.Status.OK).entity(entity).build();

        }catch(Exception e){
            return onException(e);
        }
    }

    @GET
    @Path("manager/{managerNumber}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getEmployeesByManager(@PathParam("managerNumber") Long managerNumber){

        try{

            List<Employees> in = employeeService.getEmployeesByManager(managerNumber);

            List<Employee> out = EntityMapper.INSTANCE.toEmployeeViewList(in);

            GenericEntity entity = new GenericEntity<List<Employee>>(out){};

            return Response.status(Response.Status.OK).entity(entity).build();

        }catch (Exception e){
            return onException(e);
        }
    }

}
