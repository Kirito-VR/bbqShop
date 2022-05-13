package Shop.View.Stock;

import Shop.Bean.Stock;
import Shop.Dao.StockDao;
import Shop.Dao.StockDaoImpl.StockDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author: Cqmax
 * @Date: 2022/5/3 16:04
 * @Version 1.0
 */
public class stockTest {
    public void  showStock() throws SQLException {
        StockDao Stock = new StockDaoImpl();
        Stock.Select("");//如果为空，则为查询所有的Stock
    }

    public void updataStock(Stock o) throws SQLException {
        StockDao Stock = new StockDaoImpl();
        Stock.Update(null,0);
    }

    public void remove(Stock oid) throws SQLException {
        StockDao Stock = new StockDaoImpl();
        Stock.Remove(null);
    }

    public void create(Stock o) throws SQLException {
        StockDao stock = new StockDaoImpl();
        stock.Create(o);
    }

    public static Stock newStock(Scanner input){
        Stock Stock = new Stock();
        System.out.println("------请输入Stock信息-------");
        System.out.println("请输入id:");
        Stock.setId(input.next());
        System.out.println("请输入数量:");
        Stock.setAmount(input.nextInt());
        System.out.println("请输入商品名称");
        Stock.setName(input.next());
        System.out.println("请输入进价：");
        Stock.setCost(input.nextDouble());

        return Stock;
    }

    public static void main(String[] args) {
        stockTest stock = new stockTest();

        Scanner input = new Scanner(System.in);
        int i = 0;

        try {
            while(i!=4){
                System.out.println("请输入操作:(1.更新；2.删除;3.插入；4.退出)");
                i = input.nextInt();
                switch (i){
                    case 1:stock.showStock();
                        break;
                    case 2:stock.updataStock(newStock(input));
                        break;
                    case 3:stock.remove(newStock(input));
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
