package Shop.View.Stock;

import Shop.Bean.Stock;
import Shop.Dao.StockDao;
import Shop.Dao.StockDaoImpl.StockDaoImpl;

import java.sql.SQLException;

/**
 * @Author: Cqmax
 * @Date: 2022/5/3 16:04
 * @Version 1.0
 */
public class stockTest {
    public void  showStock(){
        StockDao Stock = new StockDaoImpl();
        Stock.Select("");//如果为空，则为查询所有的Stock
    }

    public void updataStock(Stock o) throws SQLException {
        StockDao Stock = new StockDaoImpl();
        Stock.update(null,0);
    }

    public void remove(Stock oid){
        StockDao Stock = new StockDaoImpl();
        Stock.Remove(null);
    }
}
