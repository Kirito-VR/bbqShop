package Shop.Dao;

import Shop.Bean.Stock;

import java.sql.SQLException;

/**
 * @Author: Cqmax
 * @Date: 2022/5/5 23:07
 * @Version 1.0
 */
public interface StockDao {
    public void Update(String good_id, int amount) throws SQLException;
    public void Create(Stock stock) throws SQLException;
    public void Select(String good_id) throws SQLException;
    public void Remove(String good_id) throws SQLException;
}
