package org.classicmodels.model.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products", uniqueConstraints = {
        @UniqueConstraint(columnNames = "productCode")
})
public class Products implements Serializable{

  private String productCode;
  private String productName;
  private ProductLines productLine;
  private String productScale;
  private String productVendor;
  private String productDescription;
  private Long quantityInStock;
  private Double buyPrice;
  private Double MSRP;


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "product_seq")
  @SequenceGenerator(name = "product_seq", sequenceName = "CCP_", allocationSize = 20)
  @Column( unique = true, nullable = false, length = 15)
  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  @Column(nullable = false, length = 70)
  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  @ManyToOne
  @JoinColumn(name = "productLine", nullable = false)
  public ProductLines getProductLine() {
    return productLine;
  }

  public void setProductLine(ProductLines productLine) {
    this.productLine = productLine;
  }

  @Column(nullable = false, length = 10)
  public String getProductScale() {
    return productScale;
  }

  public void setProductScale(String productScale) {
    this.productScale = productScale;
  }

  @Column(nullable = false, length = 50)
  public String getProductVendor() {
    return productVendor;
  }

  public void setProductVendor(String productVendor) {
    this.productVendor = productVendor;
  }

  @Column(nullable = false, columnDefinition = "text")
  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  @Column(nullable = false, columnDefinition = "smallint(6)")
  public Long getQuantityInStock() {
    return quantityInStock;
  }

  public void setQuantityInStock(Long quantityInStock) {
    this.quantityInStock = quantityInStock;
  }

  @Column(nullable = false, columnDefinition = "decimal(10,2)")
  public Double getBuyPrice() {
    return buyPrice;
  }

  public void setBuyPrice(Double buyPrice) {
    this.buyPrice = buyPrice;
  }

  @Column(nullable = false, columnDefinition = "decimal(10,2)")
  public Double getMSRP() {
    return MSRP;
  }

  public void setMSRP(Double MSRP) {
    this.MSRP = MSRP;
  }
}
