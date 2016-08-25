package org.classicmodels.model.views;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "DetailsByOrder")
public class DetailsByOrder extends BaseViewModel{

    private Order order;
    private List<OrderDetail> orderDetailList;

    public DetailsByOrder() {}

    public DetailsByOrder(Order order, List<OrderDetail> orderDetailList) {
        this.order = order;
        this.orderDetailList = orderDetailList;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
