package Shop.View.Order;

import Shop.Bean.Order;
import Shop.Dao.OrderDao;
import Shop.Dao.OrderDaoImpl.OrderDaoImpl;

import java.sql.SQLException;

/**
 * @Author: Cqmax
 * @Date: 2022/5/3 15:57
 * @Version 1.0
 */
public class orderTest {
    public void  showOrder(){
        OrderDao order = new OrderDaoImpl();
        try {
            order.select(null);//如果为空，则为查询所有的order
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updataOrder(Order o){
        OrderDao order = new OrderDaoImpl();
        order.updata(o);
    }

    public void remove(Order oid){
        OrderDao order = new OrderDaoImpl();
        try {
            order.remove(oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
