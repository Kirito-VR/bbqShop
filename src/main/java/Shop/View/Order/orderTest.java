package Shop.View.Order;

import Shop.Bean.Order;
import Shop.Dao.OrderDao;
import Shop.Dao.OrderDaoImpl.OrderDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author: Cqmax
 * @Date: 2022/5/3 15:57
 * @Version 1.0
 */
public class orderTest {
    public void  showOrder() throws SQLException {
        OrderDao order = new OrderDaoImpl();
        order.select(null);//如果为空，则为查询所有的order
    }

    public void updataOrder(Order o) throws SQLException {
        OrderDao order = new OrderDaoImpl();
        order.updata(o);
    }

    public void remove(Order oid) throws SQLException {
        OrderDao order = new OrderDaoImpl();
        order.remove(oid);
    }

    public static Order newOrder(Scanner input){
        Order order = new Order();
        System.out.println("------请输入order信息-------");
        System.out.println("请输入oid:");
        order.setOid(input.next());
        System.out.println("请输入总金额:");
        order.setAprice(input.nextDouble());
        System.out.println("请输入订单完成详情");
        order.setInfo(input.next());
        System.out.println("请输入座位号:");
        order.setPlace(input.next());
        System.out.println("请输入交易编号:");
        order.setTransaction_id(input.next());
        return order;
    }

    public static void main(String[] args) {
        orderTest order = new orderTest();
        System.out.println("请输入操作:(1.展示；2.更新；3.删除;4.退出)");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();

        try {
            while(i!=5){
                switch (i){
                    case 1:order.showOrder();
                        break;
                    case 2:order.updataOrder(newOrder(input));
                        break;
                    case 3:order.remove(newOrder(input));
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
