package Shop.Dao;

import Shop.Bean.Good;

import java.sql.SQLException;
import java.util.Map;

/**
 * @Author: Cqmax
 * @Date: 2022/4/24 11:41
 * @Version 1.0
 */
public interface GoodDao {
    public void CreateGood(Good good) throws SQLException;
    public void updata(Good good);
    public Map select(Map map);
}
