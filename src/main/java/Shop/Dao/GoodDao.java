package Shop.Dao;

import Shop.Bean.Good;

import java.util.List;

/**
 * @Author: Cqmax
 * @Date: 2022/5/3 12:45
 * @Version 1.0
 */
public interface GoodDao {
    // 更新商品信息
    public void Updata(Good good);
    // 新增商品
    public void Create(Good good);
    // 删除商品
    public void Remove(Good good);
    // 查询商品
    public List<Good> Select(Good good);

}
