package Shop.Service;

import Shop.Bean.Order;

import java.sql.SQLException;

/**
 * @Author: Cqmax
 * @Date: 2022/5/5 17:01
 * @Version 1.0
 */
public interface OrderService {
    public void Updata(Order order) throws SQLException;
    public void Select(Order order) throws SQLException;
    public void Remove(Order order) throws SQLException;
    public void Create(Order order);
}
