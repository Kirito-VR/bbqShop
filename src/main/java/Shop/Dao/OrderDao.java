package Shop.Dao;

import Shop.Bean.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Cqmax
 * @Date: 2022/4/24 11:37
 * @Version 1.0
 */
public interface OrderDao {
    // 更新，修改订单
    public void Updata(Order order) throws SQLException;
    // 新建订单；
    public void Create(Order order);
    // 删除订单；
    public void Remove(Order order) throws SQLException;
    // 订单查询；
    public List<Order> Select(Order order) throws SQLException;

}
