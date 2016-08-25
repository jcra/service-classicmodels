package org.classicmodels.model.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "employees", uniqueConstraints = {
        @UniqueConstraint(columnNames = "employeeNumber")
})
public class Employees implements Serializable{

    private Long employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private Offices officeCode;
    private Employees reportsTo;
    private String jobTitle;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true, length = 11)
    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Column(nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = false, length = 10)
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Column(nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne
    @JoinColumn(name = "officeCode", nullable = false)
    public Offices getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(Offices officeCode) {
        this.officeCode = officeCode;
    }

    @ManyToOne
    @JoinColumn(name = "reportsTo")
    public Employees getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employees reportsTo) {
        this.reportsTo = reportsTo;
    }

    @Column(nullable = false, length = 50)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
