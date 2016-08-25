package org.classicmodels.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productLines", uniqueConstraints = {
        @UniqueConstraint(columnNames = "productLine")
})
public class ProductLines implements Serializable{

  private String productLine;
  private String textDescription;
  private String htmlDescription;
  private byte[] image;

  @Id
  @Column( unique = true, nullable = false, length = 50)
  public String getProductLine() {
    return productLine;
  }

  public void setProductLine(String productLine) {
    this.productLine = productLine;
  }

  @Column(length = 4000)
  public String getTextDescription() {
    return textDescription;
  }

  public void setTextDescription(String textDescription) {
    this.textDescription = textDescription;
  }

  @Column(columnDefinition="mediumtext")
  public String getHtmlDescription() {
    return htmlDescription;
  }

  public void setHtmlDescription(String htmlDescription) {
    this.htmlDescription = htmlDescription;
  }

  @Lob
  @Column(columnDefinition="mediumblob")
  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }
}
