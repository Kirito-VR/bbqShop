package Shop.Dao;

import java.util.Map;

/**
 * @Author: Cqmax
 * @Date: 2022/4/24 11:43
 * @Version 1.0
 */
public interface StockDao {
    public void updata(String good_id,String amount);
    public void select(String stock_id);
}
