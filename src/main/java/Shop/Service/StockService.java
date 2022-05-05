package Shop.Service;

import Shop.Bean.Stock;

import java.sql.SQLException;

/**
 * @Author: Cqmax
 * @Date: 2022/5/5 17:01
 * @Version 1.0
 */
public interface StockService {
    public void Updata(Stock stock) throws SQLException;
    public void Select(Stock stock) throws SQLException;
    public void Remove(Stock stock) throws SQLException;
    public void Create(Stock stock) throws SQLException;
}
