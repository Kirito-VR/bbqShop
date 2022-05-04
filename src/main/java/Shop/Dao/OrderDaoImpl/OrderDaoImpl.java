package Shop.Dao.OrderDaoImpl;

import Shop.Bean.Order;
import Shop.Dao.OrderDao;
import Shop.util.ConnectionHandler;
import org.ietf.jgss.Oid;
import sun.net.ConnectionResetException;

import java.sql.*;

/**
 * @author ludh
 * @date 2022/5/3 15:51:46
 */
public class OrderDaoImpl implements OrderDao {
    @Override
    public void updata(Order order) throws SQLException {
        remove(order);
        create(order);
    }
    @Override
    public void create(Order order) {
        Connection conn =null;
        PreparedStatement preparedStatement=null;
        try {//获取连接
            conn = ConnectionHandler.getConn();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            preparedStatement=conn.prepareStatement("insert into `Order` values(?,?,?,?,?);");
            preparedStatement.setString(1,order.getOid());
            preparedStatement.setDouble(2,order.getAprice());
            preparedStatement.setString(3,order.getPlace());
            preparedStatement.setString(4,order.getInfo());
            preparedStatement.setString(5,order.getTransaction_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    //删除函数
    @Override
    public void remove(Order order) throws SQLException {

        Connection conn = ConnectionHandler.getConn();
        System.out.println("OrderDao:"+conn);
        try {
            String sql="delete from `Order` where Oid=?";

            PreparedStatement pstmt=conn.prepareStatement(sql);
            Boolean bool;
            bool = pstmt.execute(sql);  //执行SQL语句
            System.out.println(bool);  //没有返回结果集所以打印false

            //conn.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("删除失败");
        }

    }

    //查询函数
    @Override
    public void select(Order order) throws SQLException {

        Connection conn = ConnectionHandler.getConn();
        System.out.println("OrderDao:"+conn);

        String sql="select * from `Order` ";
        try {
            PreparedStatement pstmt=null;
            ResultSet rs =null;

            pstmt = conn.prepareStatement(sql);
            //pstmt.setString(1,order.getOid());

            rs = pstmt.executeQuery();
            while (rs.next()){
                System.out.print(rs.getString("Oid")+" ");
                System.out.print(rs.getDouble("Aprice")+" ");
                System.out.print(rs.getString("Place")+" ");
                System.out.print(rs.getString("Info")+" ");
                System.out.println(rs.getString("transcation_id")+" ");

            }


            //conn.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }
}
