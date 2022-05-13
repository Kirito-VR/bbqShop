package Shop.Service;

import Shop.Bean.Good;

import java.util.List;

/**
 * @Author: Cqmax
 * @Date: 2022/5/5 17:00
 * @Version 1.0
 */
public interface GoodService {
    public void Updata(Good good);
    public List<Good> Select(Good good);
    public void Remove(String id);
    public void Create(Good good);
}
