package Shop.Service.OrderInfoServiceImpl;

import Shop.Bean.Order;
import Shop.Bean.OrderInfo;
import Shop.Dao.OrderInfoDao;
import Shop.Dao.OrderInfoDaoImpl.OrderInfoDaoImpl;
import Shop.Service.OrderInfoService;
import Shop.Service.OrderService;

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
        List<OrderInfo> list = new OrderInfoDaoImpl().Select(orderInfo);
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

    public static void main(String[] args) {
        List<OrderInfo> list = null;
        try {
            list = new OrderInfoServiceImpl().Select(new OrderInfo("1652453092"));
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getId());
                System.out.println(list.get(i).getGoodname());


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 把集合的数据（商品信息）转换成二维数组



    }
}
