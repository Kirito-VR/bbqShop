package Shop.Service.StockServiceImpl;

import Shop.Bean.Stock;
import Shop.Dao.StockDao;
import Shop.Dao.StockDaoImpl.StockDaoImpl;
import Shop.Service.StockService;

import java.sql.SQLException;

/**
 * @Author: Cqmax
 * @Date: 2022/5/5 17:02
 * @Version 1.0
 */
public class StockServiceImpl implements StockService {
    @Override
    public void Updata(Stock stock) throws SQLException {
        StockDao stockDao = new StockDaoImpl();
        stockDao.Update(stock.getId(),stock.getAmount());
    }

    @Override
    public void Select(Stock stock) throws SQLException {
        StockDao stockDao = new StockDaoImpl();
        stockDao.Select(stock.getId());
    }

    @Override
    public void Remove(Stock stock) throws SQLException {
        StockDao stockDao = new StockDaoImpl();
        stockDao.Remove(stock.getId());
    }

    @Override
    public void Create(Stock stock) throws SQLException {
        StockDao stockDao = new StockDaoImpl();
        stockDao.Create(stock);
    }
}
