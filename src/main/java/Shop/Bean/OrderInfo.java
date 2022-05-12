/*
author: xm
data:20220503
描述：定义一个orderinfo，订单详情类
* */
package Shop.Bean;

import java.util.Objects;

public class OrderInfo {
    private  String Id;
    private  String orderIde;
    private  String goodId;
    private String goodname;
    private  int quantify;
    private  double price;

    public void setPrice(double price) {this.price = price;}

    public void setId(String id) {
        Id = id;
    }

    public void setOrderId(String orderIde) {
        this.orderIde = orderIde;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public void setQuantify(int quantify) {
        this.quantify = quantify;
    }

    public String getId() {
        return Id;
    }

    public String getOrderId() {
        return orderIde;
    }

    public String getGoodId() {
        return goodId;
    }

    public int getQuantify() {
        return quantify;
    }

    public double getPrice() {return price;}

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderInfo orderInfo = (OrderInfo) o;
        return quantify == orderInfo.quantify &&
                Double.compare(orderInfo.price, price) == 0 &&
                Objects.equals(Id, orderInfo.Id) &&
                Objects.equals(orderIde, orderInfo.orderIde) &&
                Objects.equals(goodId, orderInfo.goodId) &&
                Objects.equals(goodname, orderInfo.goodname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, orderIde, goodId, goodname, quantify, price);
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "Id='" + Id + '\'' +
                ", orderIde='" + orderIde + '\'' +
                ", goodId='" + goodId + '\'' +
                ", goodname='" + goodname + '\'' +
                ", quantify=" + quantify +
                ", price=" + price +
                '}';
    }
}
