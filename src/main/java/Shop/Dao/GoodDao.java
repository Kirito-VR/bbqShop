package Shop.Dao;

import Shop.Bean.good;

import java.sql.SQLException;
import java.util.Map;

/**
 * @Author: Cqmax
 * @Date: 2022/4/24 11:41
 * @Version 1.0
 */
public interface GoodDao {
    public void CreateGood(good good) throws SQLException;
    public void updata(good good);
    public Map select(Map map);
}
