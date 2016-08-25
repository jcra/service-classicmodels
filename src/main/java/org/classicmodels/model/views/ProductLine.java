package org.classicmodels.model.views;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProductLine")
public class ProductLine {

    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private byte[] image;

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
