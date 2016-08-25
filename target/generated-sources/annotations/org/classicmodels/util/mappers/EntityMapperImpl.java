package org.classicmodels.util.mappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.classicmodels.model.entities.Customers;
import org.classicmodels.model.entities.Employees;
import org.classicmodels.model.entities.Offices;
import org.classicmodels.model.entities.OrderDetails;
import org.classicmodels.model.entities.Orders;
import org.classicmodels.model.entities.ProductLines;
import org.classicmodels.model.entities.Products;
import org.classicmodels.model.views.Customer;
import org.classicmodels.model.views.Employee;
import org.classicmodels.model.views.Office;
import org.classicmodels.model.views.Order;
import org.classicmodels.model.views.OrderDetail;
import org.classicmodels.model.views.Product;
import org.classicmodels.model.views.ProductLine;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2016-08-24T14:49:33-0400",
    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.6.0_45 (Sun Microsystems Inc.)"
)
public class EntityMapperImpl implements EntityMapper {

    @Override
    public Offices toOffices(Office in) {
        if ( in == null ) {
            return null;
        }

        Offices offices = new Offices();

        offices.setOfficeCode( in.getOfficeCode() );
        offices.setCity( in.getCity() );
        offices.setPhone( in.getPhone() );
        offices.setAddressLine1( in.getAddressLine1() );
        offices.setAddressLine2( in.getAddressLine2() );
        offices.setState( in.getState() );
        offices.setCountry( in.getCountry() );
        offices.setPostalCode( in.getPostalCode() );
        offices.setTerritory( in.getTerritory() );

        return offices;
    }

    @Override
    public Office toOfficeView(Offices in) {
        if ( in == null ) {
            return null;
        }

        Office office = new Office();

        office.setOfficeCode( in.getOfficeCode() );
        office.setCity( in.getCity() );
        office.setPhone( in.getPhone() );
        office.setAddressLine1( in.getAddressLine1() );
        office.setAddressLine2( in.getAddressLine2() );
        office.setState( in.getState() );
        office.setCountry( in.getCountry() );
        office.setPostalCode( in.getPostalCode() );
        office.setTerritory( in.getTerritory() );

        return office;
    }

    @Override
    public Customers toCustomers(Customer in) {
        if ( in == null ) {
            return null;
        }

        Customers customers = new Customers();

        Employees salesRepEmployeeNumber = new Employees();
        customers.setSalesRepEmployeeNumber( salesRepEmployeeNumber );

        salesRepEmployeeNumber.setEmployeeNumber( in.getSalesRepEmployeeNumber() );
        customers.setCustomerNumber( in.getCustomerNumber() );
        customers.setCustomerName( in.getCustomerName() );
        customers.setContactLastName( in.getContactLastName() );
        customers.setContactFirstName( in.getContactFirstName() );
        customers.setPhone( in.getPhone() );
        customers.setAddressLine1( in.getAddressLine1() );
        customers.setAddressLine2( in.getAddressLine2() );
        customers.setCity( in.getCity() );
        customers.setState( in.getState() );
        customers.setPostalCode( in.getPostalCode() );
        customers.setCountry( in.getCountry() );
        customers.setCreditLimit( in.getCreditLimit() );

        return customers;
    }

    @Override
    public Customer toCustomerView(Customers in) {
        if ( in == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setSalesRepEmployeeNumber( inSalesRepEmployeeNumberEmployeeNumber( in ) );
        customer.setCustomerNumber( in.getCustomerNumber() );
        customer.setCustomerName( in.getCustomerName() );
        customer.setContactLastName( in.getContactLastName() );
        customer.setContactFirstName( in.getContactFirstName() );
        customer.setPhone( in.getPhone() );
        customer.setAddressLine1( in.getAddressLine1() );
        customer.setAddressLine2( in.getAddressLine2() );
        customer.setCity( in.getCity() );
        customer.setState( in.getState() );
        customer.setPostalCode( in.getPostalCode() );
        customer.setCountry( in.getCountry() );
        customer.setCreditLimit( in.getCreditLimit() );

        return customer;
    }

    @Override
    public Employees toEmployees(Employee in) {
        if ( in == null ) {
            return null;
        }

        Employees employees = new Employees();

        Employees reportsTo = new Employees();
        Offices officeCode = new Offices();
        employees.setReportsTo( reportsTo );
        employees.setOfficeCode( officeCode );

        officeCode.setOfficeCode( in.getOfficesCode() );
        reportsTo.setEmployeeNumber( in.getReportsTo() );
        employees.setEmployeeNumber( in.getEmployeeNumber() );
        employees.setLastName( in.getLastName() );
        employees.setFirstName( in.getFirstName() );
        employees.setExtension( in.getExtension() );
        employees.setEmail( in.getEmail() );
        employees.setJobTitle( in.getJobTitle() );

        return employees;
    }

    @Override
    public Employee toEmployeeView(Employees in) {
        if ( in == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setReportsTo( inReportsToEmployeeNumber( in ) );
        employee.setOfficesCode( inOfficeCodeOfficeCode( in ) );
        employee.setEmployeeNumber( in.getEmployeeNumber() );
        employee.setLastName( in.getLastName() );
        employee.setFirstName( in.getFirstName() );
        employee.setExtension( in.getExtension() );
        employee.setEmail( in.getEmail() );
        employee.setJobTitle( in.getJobTitle() );

        return employee;
    }

    @Override
    public Orders toOrders(Order in) {
        if ( in == null ) {
            return null;
        }

        Orders orders = new Orders();

        Customers customerNumber = new Customers();
        orders.setCustomerNumber( customerNumber );

        customerNumber.setCustomerNumber( in.getCustomerNumber() );
        orders.setOrderNumber( in.getOrderNumber() );
        orders.setOrderDate( in.getOrderDate() );
        orders.setRequiredDate( in.getRequiredDate() );
        orders.setShippedDate( in.getShippedDate() );
        orders.setStatus( in.getStatus() );
        orders.setComments( in.getComments() );

        return orders;
    }

    @Override
    public Order toOrderView(Orders in) {
        if ( in == null ) {
            return null;
        }

        Order order = new Order();

        order.setCustomerNumber( inCustomerNumberCustomerNumber( in ) );
        order.setOrderNumber( in.getOrderNumber() );
        order.setOrderDate( in.getOrderDate() );
        order.setRequiredDate( in.getRequiredDate() );
        order.setShippedDate( in.getShippedDate() );
        order.setStatus( in.getStatus() );
        order.setComments( in.getComments() );

        return order;
    }

    @Override
    public OrderDetails toOrderDetails(OrderDetail in) {
        if ( in == null ) {
            return null;
        }

        OrderDetails orderDetails = new OrderDetails();

        Orders orderNumber = new Orders();
        Products productCode = new Products();
        orderDetails.setProductCode( productCode );
        orderDetails.setOrderNumber( orderNumber );

        productCode.setProductCode( in.getProductCode() );
        orderNumber.setOrderNumber( in.getOrderNumber() );
        orderDetails.setQuantityOrdered( in.getQuantityOrdered() );
        if ( in.getPriceEach() != null ) {
            orderDetails.setPriceEach( in.getPriceEach() );
        }
        orderDetails.setOrderLineNumber( in.getOrderLineNumber() );

        return orderDetails;
    }

    @Override
    public OrderDetail toOrderDetailView(OrderDetails in) {
        if ( in == null ) {
            return null;
        }

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setProductCode( inProductCodeProductCode( in ) );
        orderDetail.setOrderNumber( inOrderNumberOrderNumber( in ) );
        orderDetail.setQuantityOrdered( in.getQuantityOrdered() );
        orderDetail.setPriceEach( in.getPriceEach() );
        orderDetail.setOrderLineNumber( in.getOrderLineNumber() );

        return orderDetail;
    }

    @Override
    public Products toProducts(Product in) {
        if ( in == null ) {
            return null;
        }

        Products products = new Products();

        ProductLines productLine = new ProductLines();
        products.setProductLine( productLine );

        productLine.setProductLine( in.getProductLine() );
        products.setProductCode( in.getProductCode() );
        products.setProductName( in.getProductName() );
        products.setProductScale( in.getProductScale() );
        products.setProductVendor( in.getProductVendor() );
        products.setProductDescription( in.getProductDescription() );
        products.setQuantityInStock( in.getQuantityInStock() );
        products.setBuyPrice( in.getBuyPrice() );
        products.setMSRP( in.getMSRP() );

        return products;
    }

    @Override
    public Product toProductView(Products in) {
        if ( in == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductLine( inProductLineProductLine( in ) );
        product.setProductCode( in.getProductCode() );
        product.setProductName( in.getProductName() );
        product.setProductScale( in.getProductScale() );
        product.setProductVendor( in.getProductVendor() );
        product.setProductDescription( in.getProductDescription() );
        product.setQuantityInStock( in.getQuantityInStock() );
        product.setBuyPrice( in.getBuyPrice() );
        product.setMSRP( in.getMSRP() );

        return product;
    }

    @Override
    public ProductLines toProductLines(ProductLine in) {
        if ( in == null ) {
            return null;
        }

        ProductLines productLines = new ProductLines();

        productLines.setProductLine( in.getProductLine() );
        productLines.setTextDescription( in.getTextDescription() );
        productLines.setHtmlDescription( in.getHtmlDescription() );
        if ( in.getImage() != null ) {
            byte[] image = in.getImage();
            productLines.setImage( Arrays.copyOf( image, image.length ) );
        }

        return productLines;
    }

    @Override
    public ProductLine toProductLineView(ProductLines in) {
        if ( in == null ) {
            return null;
        }

        ProductLine productLine = new ProductLine();

        productLine.setProductLine( in.getProductLine() );
        productLine.setTextDescription( in.getTextDescription() );
        productLine.setHtmlDescription( in.getHtmlDescription() );
        if ( in.getImage() != null ) {
            byte[] image = in.getImage();
            productLine.setImage( Arrays.copyOf( image, image.length ) );
        }

        return productLine;
    }

    @Override
    public List<Office> toOfficeViewList(List<Offices> in) {
        if ( in == null ) {
            return null;
        }

        List<Office> list = new ArrayList<Office>();
        for ( Offices offices : in ) {
            list.add( toOfficeView( offices ) );
        }

        return list;
    }

    @Override
    public List<Customer> toCustomerViewList(List<Customers> in) {
        if ( in == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>();
        for ( Customers customers : in ) {
            list.add( toCustomerView( customers ) );
        }

        return list;
    }

    @Override
    public List<Employee> toEmployeeViewList(List<Employees> in) {
        if ( in == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>();
        for ( Employees employees : in ) {
            list.add( toEmployeeView( employees ) );
        }

        return list;
    }

    @Override
    public List<Order> toOrderViewList(List<Orders> in) {
        if ( in == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>();
        for ( Orders orders : in ) {
            list.add( toOrderView( orders ) );
        }

        return list;
    }

    @Override
    public List<OrderDetail> toOrderDetailViewList(List<OrderDetails> in) {
        if ( in == null ) {
            return null;
        }

        List<OrderDetail> list = new ArrayList<OrderDetail>();
        for ( OrderDetails orderDetails : in ) {
            list.add( toOrderDetailView( orderDetails ) );
        }

        return list;
    }

    @Override
    public List<Product> toProductViewList(List<Products> in) {
        if ( in == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>();
        for ( Products products : in ) {
            list.add( toProductView( products ) );
        }

        return list;
    }

    @Override
    public List<ProductLine> toProductLineViewList(List<ProductLines> in) {
        if ( in == null ) {
            return null;
        }

        List<ProductLine> list = new ArrayList<ProductLine>();
        for ( ProductLines productLines : in ) {
            list.add( toProductLineView( productLines ) );
        }

        return list;
    }

    @Override
    public List<OrderDetails> toOrderDetailsList(List<OrderDetail> orderDetailList) {
        if ( orderDetailList == null ) {
            return null;
        }

        List<OrderDetails> list = new ArrayList<OrderDetails>();
        for ( OrderDetail orderDetail : orderDetailList ) {
            list.add( toOrderDetails( orderDetail ) );
        }

        return list;
    }

    private Long inSalesRepEmployeeNumberEmployeeNumber(Customers customers) {

        if ( customers == null ) {
            return null;
        }
        Employees salesRepEmployeeNumber = customers.getSalesRepEmployeeNumber();
        if ( salesRepEmployeeNumber == null ) {
            return null;
        }
        Long employeeNumber = salesRepEmployeeNumber.getEmployeeNumber();
        if ( employeeNumber == null ) {
            return null;
        }
        return employeeNumber;
    }

    private Long inReportsToEmployeeNumber(Employees employees) {

        if ( employees == null ) {
            return null;
        }
        Employees reportsTo = employees.getReportsTo();
        if ( reportsTo == null ) {
            return null;
        }
        Long employeeNumber = reportsTo.getEmployeeNumber();
        if ( employeeNumber == null ) {
            return null;
        }
        return employeeNumber;
    }

    private Long inOfficeCodeOfficeCode(Employees employees) {

        if ( employees == null ) {
            return null;
        }
        Offices officeCode = employees.getOfficeCode();
        if ( officeCode == null ) {
            return null;
        }
        Long officeCode_ = officeCode.getOfficeCode();
        if ( officeCode_ == null ) {
            return null;
        }
        return officeCode_;
    }

    private Long inCustomerNumberCustomerNumber(Orders orders) {

        if ( orders == null ) {
            return null;
        }
        Customers customerNumber = orders.getCustomerNumber();
        if ( customerNumber == null ) {
            return null;
        }
        Long customerNumber_ = customerNumber.getCustomerNumber();
        if ( customerNumber_ == null ) {
            return null;
        }
        return customerNumber_;
    }

    private String inProductCodeProductCode(OrderDetails orderDetails) {

        if ( orderDetails == null ) {
            return null;
        }
        Products productCode = orderDetails.getProductCode();
        if ( productCode == null ) {
            return null;
        }
        String productCode_ = productCode.getProductCode();
        if ( productCode_ == null ) {
            return null;
        }
        return productCode_;
    }

    private Long inOrderNumberOrderNumber(OrderDetails orderDetails) {

        if ( orderDetails == null ) {
            return null;
        }
        Orders orderNumber = orderDetails.getOrderNumber();
        if ( orderNumber == null ) {
            return null;
        }
        Long orderNumber_ = orderNumber.getOrderNumber();
        if ( orderNumber_ == null ) {
            return null;
        }
        return orderNumber_;
    }

    private String inProductLineProductLine(Products products) {

        if ( products == null ) {
            return null;
        }
        ProductLines productLine = products.getProductLine();
        if ( productLine == null ) {
            return null;
        }
        String productLine_ = productLine.getProductLine();
        if ( productLine_ == null ) {
            return null;
        }
        return productLine_;
    }
}
