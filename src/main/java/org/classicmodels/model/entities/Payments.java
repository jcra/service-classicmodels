package org.classicmodels.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "payments", uniqueConstraints = {
        @UniqueConstraint(columnNames = "checkNumber")
})
public class Payments implements Serializable{

    private Customers customerNumber;
    private String checkNumber;
    private Date paymentDate;
    private Double amount;

    @Id
    @ManyToOne
    @JoinColumn(nullable= false, name = "customerNumber")
    public Customers getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Customers customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Id
    @Column(nullable = false, length = 50)
    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Column(nullable = false, columnDefinition = "date")
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Column(nullable = false, columnDefinition = "decimal(10,2)")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
