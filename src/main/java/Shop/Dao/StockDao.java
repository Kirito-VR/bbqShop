package Shop.Dao;

import java.sql.SQLException;

/**
 * @Author: Cqmax
 * @Date: 2022/5/3 22:57
 * @Version 1.0
 */
public interface StockDao {
    public void update(String good_id,int amount) throws SQLException;
    public void create(String good_id,int amount);
    public void Select(String good_id);
    public void Remove(String good_id);
}
