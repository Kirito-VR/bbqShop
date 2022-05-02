package Shop.Dao;

import java.util.Map;

/**
 * @Author: Cqmax
 * @Date: 2022/4/24 11:37
 * @Version 1.0
 */
public interface OrderDao {
    // 更新，修改订单
    public void updata(Order order);
    // 新建订单；
    public void create(Order order);
    // 删除订单；
    public void remove(Order order);
    // 订单查询；
    public Map select(Order order);
}
