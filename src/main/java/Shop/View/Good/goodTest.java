package Shop.View.Good;

import Shop.Bean.Good;
import Shop.Dao.GoodDao;
import Shop.Dao.GoodDaoImpl.GoodDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author: Cqmax
 * @Date: 2022/5/3 15:51
 * @Version 1.0
 */
public class goodTest {
    public void  showGood() throws SQLException {
        GoodDao Good = new GoodDaoImpl();
        Good.selectGood(null);//如果为空，则为查询所有的Good
    }

    public void updataGood(Good o) throws SQLException {
        GoodDao Good = new GoodDaoImpl();
        Good.updata(o);
    }

    public void remove(Good id) throws SQLException {
        GoodDao Good = new GoodDaoImpl();
        Good.deleteGood(id);
    }

    public static Good newGood(Scanner input){
        Good Good = new Good();
        System.out.println("------请输入Good信息-------");
        System.out.println("请输入id:");
        Good.setId(input.next());
        System.out.println("请输入总金额:");
        Good.setPrice(input.nextDouble());
        System.out.println("请输入订单完成详情");

        return Good;
    }

    public static void main(String[] args) {
        goodTest Good = new goodTest();
        System.out.println("请输入操作:(1.展示；2.更新；3.删除;4.退出)");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();

        try {
            while(i!=5){
                switch (i){
                    case 1:Good.showGood();
                        break;
                    case 2:Good.updataGood(newGood(input));
                        break;
                    case 3:Good.remove(newGood(input));
                        break;
                    case 4:i=5;
                        break;
                    default:
                        break;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
