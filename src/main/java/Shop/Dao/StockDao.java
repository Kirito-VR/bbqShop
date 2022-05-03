package Shop.Dao;

import Shop.Bean.Stock;

import java.sql.SQLException;
import java.util.Map;

/**
 * @Author: Cqmax
 * @Date: 2022/4/24 11:43
 * @Version 1.0
 */
public interface StockDao {
    public void update(String good_id,int amount) throws SQLException;
    public void create(String good_id,int amount);
    public void Select(String good_id);
}
