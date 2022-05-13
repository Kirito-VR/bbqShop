package Shop.Service;

import Shop.Bean.OrderInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Cqmax
 * @Date: 2022/5/6 14:54
 * @Version 1.0
 */
public interface OrderInfoService {
    public void Create(OrderInfo orderInfo) throws SQLException;
    public void Update(OrderInfo orderInfo) throws SQLException;
    public List<OrderInfo> Select(OrderInfo orderInfo) throws SQLException;
    public List<OrderInfo> Select(String oid) throws SQLException;
    public void Remove(String id) throws SQLException;
}
