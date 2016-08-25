package org.classicmodels.util.mappers;

import org.classicmodels.model.entities.*;
import org.classicmodels.model.views.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EntityMapper {

    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    Offices toOffices(Office in);
    Office toOfficeView(Offices in);

    @Mapping(source = "salesRepEmployeeNumber", target = "Customers.salesRepEmployeeNumber.employeeNumber")
    Customers toCustomers(Customer in);

    @Mapping(source = "salesRepEmployeeNumber.employeeNumber", target = "salesRepEmployeeNumber")
    Customer toCustomerView(Customers in);

    @Mappings({
            @Mapping(source = "officesCode", target = "Employees.officeCode.officeCode"),
            @Mapping(source = "reportsTo", target = "Employees.reportsTo.employeeNumber")
    })
    Employees toEmployees(Employee in);


    @Mappings({
            @Mapping(source = "officeCode.officeCode", target = "officesCode"),
            @Mapping(source = "reportsTo.employeeNumber", target = "reportsTo")
    })
    Employee toEmployeeView(Employees in);

    @Mapping(source = "customerNumber",target = "Orders.customerNumber.customerNumber")
    Orders toOrders(Order in);

    @Mapping(source = "customerNumber.customerNumber",target = "customerNumber")
    Order toOrderView(Orders in);

    @Mappings({
            @Mapping(source = "orderNumber", target = "OrderDetails.orderNumber.orderNumber"),
            @Mapping(source = "productCode", target = "OrderDetails.productCode.productCode")
    })
    OrderDetails toOrderDetails(OrderDetail in);

    @Mappings({
            @Mapping(source = "orderNumber.orderNumber", target = "orderNumber"),
            @Mapping(source = "productCode.productCode", target = "productCode")
    })
    OrderDetail toOrderDetailView(OrderDetails in);


    @Mapping(source = "productLine", target = "Products.productLine.productLine")
    Products toProducts(Product in);

    @Mapping(source = "productLine.productLine", target = "productLine")
    Product toProductView(Products in);

    ProductLines toProductLines(ProductLine in);
    ProductLine toProductLineView(ProductLines in);

    /** Collection Mapping */


    /** To view list mapping **/
    List<Office> toOfficeViewList(List<Offices> in);
    List<Customer> toCustomerViewList(List<Customers> in);
    List<Employee> toEmployeeViewList(List<Employees> in);
    List<Order> toOrderViewList(List<Orders> in);
    List<OrderDetail> toOrderDetailViewList(List<OrderDetails> in);
    List<Product> toProductViewList(List<Products> in);
    List<ProductLine> toProductLineViewList(List<ProductLines> in);

    /** to entity object mapping **/
    List<OrderDetails> toOrderDetailsList(List<OrderDetail> orderDetailList);
}
