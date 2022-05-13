package Shop.Service.OrderInfoServiceImpl;

import Shop.Bean.OrderInfo;
import Shop.Dao.OrderInfoDao;
import Shop.Dao.OrderInfoDaoImpl.OrderInfoDaoImpl;
import Shop.Service.OrderInfoService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Cqmax
 * @Date: 2022/5/6 14:55
 * @Version 1.0
 */
public class OrderInfoServiceImpl implements OrderInfoService {
    @Override
    public void Create(OrderInfo orderInfo) throws SQLException {
        OrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
        orderInfoDao.Create(orderInfo);
    }

    @Override
    public void Update(OrderInfo orderInfo) throws SQLException {
        OrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
        orderInfoDao.Update(orderInfo);
    }

    @Override
    public List<OrderInfo> Select(OrderInfo orderInfo) throws SQLException {
        OrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
        return null;
    }

    @Override
    public List<OrderInfo> Select(String oid) throws SQLException {
        List<OrderInfo> list = new OrderInfoDaoImpl().Select(oid);
        return list;
    }

    @Override
    public void Remove(String id) throws SQLException {
        OrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
        orderInfoDao.Remove(id);

    }
}
