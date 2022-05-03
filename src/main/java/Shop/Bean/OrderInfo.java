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
    private  int quantify;
    public void setId(String id) {
        Id = id;
    }

    public void setOrderIde(String orderIde) {
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

    public String getOrderIde() {
        return orderIde;
    }

    public String getGoodId() {
        return goodId;
    }

    public int getQuantify() {
        return quantify;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderInfo orderInfo = (OrderInfo) o;
        return quantify == orderInfo.quantify && Objects.equals(Id, orderInfo.Id) && Objects.equals(orderIde, orderInfo.orderIde) && Objects.equals(goodId, orderInfo.goodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, orderIde, goodId, quantify);
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "Id='" + Id + '\'' +
                ", orderIde='" + orderIde + '\'' +
                ", goodId='" + goodId + '\'' +
                ", quantify=" + quantify +
                '}';
    }
}