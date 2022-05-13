package Shop.Service;

import Shop.Bean.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Cqmax
 * @Date: 2022/5/5 17:01
 * @Version 1.0
 */
public interface OrderService {
    public void Updata(Order order) throws SQLException;
    public void Updata();
    public List<Order> Select(Order order) throws SQLException;
    public void Remove(Order order) throws SQLException;
    public void Create(Order order) throws SQLException;
}
