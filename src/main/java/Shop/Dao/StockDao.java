package Shop.Dao;

import Shop.Bean.Stock;

import java.sql.SQLException;

/**
 * @Author: Cqmax
 * @Date: 2022/5/3 22:57
 * @Version 1.0
 */
public interface StockDao {
    // 更新库存
    public void Update(String good_id,int amount) throws SQLException;
    // 创建新库存
    public void Create(Stock stock) throws SQLException;
    // 查询库存
    public void Select(String good_id) throws SQLException;
    // 删除库存；
    public void Remove(String good_id) throws SQLException;
}
