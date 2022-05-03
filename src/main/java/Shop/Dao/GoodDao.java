package Shop.Dao;

import Shop.Bean.Good;

/**
 * @Author: Cqmax
 * @Date: 2022/5/3 12:45
 * @Version 1.0
 */
public interface GoodDao {
    public void updata(Good good);
    public void newGood(Good good);
    public void deleteGood(Good good);

}
