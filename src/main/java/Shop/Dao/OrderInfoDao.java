package Shop.Dao;

import Shop.Bean.OrderInfo;

/**
 * @Author: Cqmax
 * @Date: 2022/5/4 21:12
 * @Version 1.0
 */
public interface OrderInfoDao {
    public void Create(OrderInfo orderInfo);
    public void Update(OrderInfo orderInfo);
    public void Select(OrderInfo orderInfo);
    public void Remove(OrderInfo orderInfo);
}
