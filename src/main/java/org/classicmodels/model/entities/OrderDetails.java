package org.classicmodels.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "orderDetails", uniqueConstraints = {
        @UniqueConstraint(columnNames = "orderNumber"),
        @UniqueConstraint(columnNames = "productCode")
})
public class OrderDetails implements Serializable{


    private Orders orderNumber;
    private Products productCode;
    private int quantityOrdered;
    private Double priceEach;
    private int orderLineNumber;

    @Id
    @ManyToOne
    @JoinColumn(name = "orderNumber", nullable = false)
    public Orders getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Orders orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "productCode", nullable = false)
    public Products getProductCode() {
        return productCode;
    }

    public void setProductCode(Products productCode) {
        this.productCode = productCode;
    }

    @Column(nullable = false, length = 11)
    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    @Column(nullable = false, columnDefinition = "decimal(10,2)")
    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    @Column(nullable = false, columnDefinition = "smallint(6)")
    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }
}
