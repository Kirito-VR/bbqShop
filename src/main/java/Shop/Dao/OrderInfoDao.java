package Shop.Dao;

import Shop.Bean.OrderInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Cqmax
 * @Date: 2022/5/4 21:12
 * @Version 1.0
 */
public interface OrderInfoDao {
    public void Create(OrderInfo orderInfo) throws SQLException;
    public void Update(OrderInfo orderInfo) throws SQLException;
    public List<OrderInfo> Select(OrderInfo orderInfo) throws SQLException;
    public List<OrderInfo> Select(String oid) throws SQLException;
    public void Remove(String Oid) throws SQLException;
}
