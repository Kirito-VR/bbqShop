package Shop.View.Order;

import Shop.Bean.OrderInfo;
import Shop.Dao.OrderInfoDao;
import Shop.Dao.OrderInfoDaoImpl.OrderInfoDaoImpl;

import java.sql.SQLException;

/**
 * Created by xm on 2022/5/10 16:20
 * title:
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        //测试用例 传入一个orderinfo，返回一个orderinfo
        OrderInfo of=new OrderInfo();
        of.setGoodId("12123");
        of.setOrderId("121216");
        of.setId(1213+"");
        of.setGoodname("韭菜");
        of.setPrice(121);
        of.setQuantify(124);
        System.out.println(of);
       OrderChange oc=new OrderChange(of);
    }
}
