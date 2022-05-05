package Shop.Service.GoodServiceImpl;

import Shop.Bean.Good;
import Shop.Dao.GoodDao;
import Shop.Dao.GoodDaoImpl.GoodDaoImpl;
import Shop.Service.GoodService;

/**
 * @Author: Cqmax
 * @Date: 2022/5/5 17:01
 * @Version 1.0
 */
public class GoodServiceImpl implements GoodService {
    @Override
    public void Updata(Good good) {
        GoodDao gooddao =new GoodDaoImpl();
        gooddao.Updata(good);
    }

    @Override
    public void Select(Good good) {
        GoodDao gooddao =new GoodDaoImpl();
        gooddao.Select(good);
    }

    @Override
    public void Remove(Good good) {
        GoodDao gooddao =new GoodDaoImpl();
        gooddao.Remove(good);
    }

    @Override
    public void Create(Good good) {
        GoodDao gooddao =new GoodDaoImpl();
        gooddao.Create(good);
    }
}
