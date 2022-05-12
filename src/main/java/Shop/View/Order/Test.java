package Shop.View.Order;

import Shop.Bean.OrderInfo;
import Shop.View.Order.OrderChange;

/**
 * Created by xm on 2022/5/10 16:20
 * title:
 */
public class Test {
    public static void main(String[] args) {
        //测试用例 传入一个orderinfo，返回一个orderinfo
        OrderInfo of=new OrderInfo();
        of.setQuantify(12);
        of.setOrderId("1234");
        of.setGoodId("12345");
        of.setId("1234");
        of.setPrice(121);
        OrderChange oc=new OrderChange(of);
        OrderInfo uf=oc.backcalss();

        //        new OrderChange(O);
    }
}
