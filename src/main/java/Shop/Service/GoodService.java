package Shop.Service;

import Shop.Bean.Good;

/**
 * @Author: Cqmax
 * @Date: 2022/5/5 17:00
 * @Version 1.0
 */
public interface GoodService {
    public void Updata(Good good);
    public void Select(Good good);
    public void Remove(Good good);
    public void Create(Good good);
}
