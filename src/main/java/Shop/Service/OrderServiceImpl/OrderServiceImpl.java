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

    @Override
    public void Select(Order order) throws SQLException {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.Select(order);
    }

    @Override
    public void Remove(Order order) throws SQLException {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.Remove(order);

    }

    @Override
    public void Create(Order order) throws SQLException {
        OrderDao orderDao = new OrderDaoImpl();
        OrderInfoDao orderInfo =  new OrderInfoDaoImpl();
        // 获取所有的订单详情信息，汇总所有金额；
        List<OrderInfo> info_list = orderInfo.Select(order.getOid());
        double sum_price = 0;
        for(int i=0;i<info_list.size();i++){
            sum_price+= info_list.get(i).getQuantify();
        }
        order.setAprice(sum_price);
        orderDao.Create(order);
    }
}
