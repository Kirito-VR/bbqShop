package Shop.View.Order;

import Shop.Bean.Order;
import Shop.Dao.OrderDao;
import Shop.Dao.OrderDaoImpl.OrderDaoImpl;

import java.util.Scanner;

/**
 * @Author: Cqmax
 * @Date: 2022/5/3 15:57
 * @Version 1.0
 */
public class orderTest {
    public void  showOrder(){
        OrderDao order = new OrderDaoImpl();
        order.select(null);//如果为空，则为查询所有的order
    }

    public void updataOrder(Order o){
        OrderDao order = new OrderDaoImpl();
        order.updata(o);
    }

    public void remove(Order oid){
        OrderDao order = new OrderDaoImpl();
        order.remove(oid);
    }

    public static void main(String[] args) {
        orderTest order = new orderTest();
        System.out.println("请输入操作:(1.展示；2.更新；3.删除;4.退出)");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        while(i!=5){
        switch (i){
            case 1:order.showOrder();
                break;
            case 2:order.updataOrder(new Order());
                break;
            case 3:order.remove(new Order());
                break;
            case 4:i=5;
                break;
            default:
                break;
        }
        }
    }
}
