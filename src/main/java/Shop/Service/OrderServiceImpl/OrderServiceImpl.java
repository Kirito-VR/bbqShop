package Shop.Service.OrderServiceImpl;

import Shop.Bean.Order;
import Shop.Bean.OrderInfo;
import Shop.Dao.OrderDao;
import Shop.Dao.OrderDaoImpl.OrderDaoImpl;
import Shop.Dao.OrderInfoDao;
import Shop.Dao.OrderInfoDaoImpl.OrderInfoDaoImpl;
import Shop.Service.OrderService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Cqmax
 * @Date: 2022/5/5 17:02
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public void Updata(Order order) throws SQLException {
        OrderDao orderDao = new OrderDaoImpl();

        orderDao.Updata(order);
    }
    public void Updata(){
        OrderDao orderDao = new OrderDaoImpl();
        try {
            List<Order> oidList = orderDao.Select(null);
            Order order = null;
            OrderInfoDao orderInfo =  new OrderInfoDaoImpl();
            String oid = null;
            for(int j=0;j<oidList.size();j++){
                order = oidList.get(j);
                oid = order.getOid();

                List<OrderInfo> info_list = orderInfo.Select(oid);
                double sum_price = 0;
                for(int i=0;i<info_list.size();i++){
                    sum_price+= info_list.get(i).getQuantify()*info_list.get(i).getPrice();
                }
                order.setAprice(sum_price);
                orderDao.Updata(order);

            }
            // 获取所有的订单详情信息，汇总所有金额；

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    @Override
    public List<Order> Select(Order order) throws SQLException {
        OrderDao orderDao = new OrderDaoImpl();
        return orderDao.Select(order);
    }

    @Override
    public void Remove(Order order) throws SQLException {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.Remove(order);

    }

    @Override
    public void Create(Order order) throws SQLException {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.Create(order);
    }
}
