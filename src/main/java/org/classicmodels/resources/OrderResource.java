package org.classicmodels.resources;

import org.classicmodels.model.entities.OrderDetails;
import org.classicmodels.model.entities.Orders;
import org.classicmodels.model.views.DetailsByOrder;
import org.classicmodels.model.views.Order;
import org.classicmodels.model.views.OrderDetail;
import org.classicmodels.services.interfaces.CustomerService;
import org.classicmodels.services.interfaces.OrderService;
import org.classicmodels.services.interfaces.ProductService;
import org.classicmodels.util.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("orders")
public class OrderResource extends BaseResource{

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;


    @POST
    @Path("order")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Order order){

        try{

            Orders in = EntityMapper.INSTANCE.toOrders(order);

            in.setCustomerNumber(customerService.getCustomer(order.getCustomerNumber()));

            orderService.save(in);

            order = EntityMapper.INSTANCE.toOrderView(in);

            return  Response.status(Response.Status.OK).entity(order).build();

        }catch(Exception e){
            return onException(e);
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll(){

        try{

            List<Orders> in = orderService.getAll();

            List<Order> out = EntityMapper.INSTANCE.toOrderViewList(in);

            GenericEntity entity = new GenericEntity<List<Order>>(out){};

            return Response.status(Response.Status.OK).entity(entity).build();

        }catch(Exception e){
            return onException(e);
        }
    }

    @GET
    @Path("order/{orderNumber}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getOrder(@PathParam("orderNumber") Long orderNumber){

        try{

            Orders order = orderService.getOrder(orderNumber);

            Order out = EntityMapper.INSTANCE.toOrderView(order);

            return Response.status(Response.Status.OK).entity(out).build();

        }catch(Exception e){
            return onException(e);
        }
    }

    @GET
    @Path("order/customer/{customerNumber}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getOrderByCustomer(@PathParam("customerNumber") Long customerNumber){

        try{

            List<Orders> in = orderService.getOrderByCustomer(customerNumber);

            List<Order> out = EntityMapper.INSTANCE.toOrderViewList(in);

            GenericEntity entity = new GenericEntity<List<Order>>(out){};

            return Response.status(Response.Status.OK).entity(entity).build();

        }catch (Exception e){
            return onException(e);
        }
    }


    @GET
    @Path("order/{orderNumber}/details")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getOrderDetails(@PathParam("orderNumber") Long orderNumber){

        try{

            List<OrderDetails> in = orderService.getOrderDetails(orderNumber);

            List<OrderDetail> out = EntityMapper.INSTANCE.toOrderDetailViewList(in);

            Order order = EntityMapper.INSTANCE.toOrderView(in.get(0).getOrderNumber());

            DetailsByOrder detailsByOrder = new DetailsByOrder(order, out);

            return Response.status(Response.Status.OK).entity(detailsByOrder).build();

        }catch(Exception e){
            return onException(e);
        }
    }

    @POST
    @Path("order/details")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createDetails(List<OrderDetail> orderDetailList){

        try{

            List<OrderDetails> in = EntityMapper.INSTANCE.toOrderDetailsList(orderDetailList);

            int i = 0;
            for (OrderDetail odv : orderDetailList) {
                in.get(i).setOrderNumber(orderService.getOrder(odv.getOrderNumber()));
                in.get(i).setProductCode(productService.getProduct(odv.getProductCode()));
                i++;
            }

            orderService.saveOrderDetails(in);

            orderDetailList = EntityMapper.INSTANCE.toOrderDetailViewList(in);

            return  Response.status(Response.Status.OK).entity(orderDetailList).build();

        }catch(Exception e){
            return onException(e);
        }
    }


}
