package Shop.Service.OrderServiceImpl;

import Shop.Bean.Order;
import Shop.Dao.OrderDao;
import Shop.Dao.OrderDaoImpl.OrderDaoImpl;
import Shop.Service.OrderService;

import java.sql.SQLException;

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
    public void Create(Order order) {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.Create(order);
    }
}
