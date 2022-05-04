package Shop.Dao.OrderDaoImpl;

import Shop.Bean.Order;
import Shop.Dao.OrderDao;
import Shop.util.ConnectionHandler;

import java.sql.*;

/**
 * @author ludh
 * @date 2022/5/3 15:51:46
 */
public class OrderDaoImpl implements OrderDao {
    @Override
    public void Updata(Order order) throws SQLException {
        Remove(order);
        Create(order);
    }

    @Override
    public void Create(Order order) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {//获取连接
            conn = ConnectionHandler.getConn();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            preparedStatement = conn.prepareStatement("insert into `Order` values(?,?,?,?,?);");
            preparedStatement.setString(1, order.getOid());
            preparedStatement.setDouble(2, order.getAprice());
            preparedStatement.setString(3, order.getPlace());
            preparedStatement.setString(4, order.getInfo());
            preparedStatement.setString(5, order.getTransaction_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
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
    public void Remove(Order order) throws SQLException {

        Connection conn = ConnectionHandler.getConn();
        System.out.println("OrderDao:" + conn);
        try {
            String sql = "delete from `Order` where Oid=？";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            Boolean bool;
            pstmt.setString(1,order.getOid());
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
    public void Select(Order order) throws SQLException {

        Connection conn = ConnectionHandler.getConn();
        System.out.println("OrderDao:" + conn);

        try {
            if (order == null) {
                String sql = "select * from `Order` ";
                PreparedStatement pstmt = null;
                ResultSet rs = null;

                pstmt = conn.prepareStatement(sql);
                //pstmt.setString(1,order.getOid());

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    System.out.print(rs.getString("Oid") + " ");
                    System.out.print(rs.getDouble("Aprice") + " ");
                    System.out.print(rs.getString("Place") + " ");
                    System.out.print(rs.getString("Info") + " ");
                    System.out.println(rs.getString("transcation_id") + " ");
                }
            }else {
                String sql = "select * from `Order` where oid="+order.getOid();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = null;
                pstmt = conn.prepareStatement(sql);
                //pstmt.setString(1,order.getOid());

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    System.out.print(rs.getString("Oid") + " ");
                    System.out.print(rs.getDouble("Aprice") + " ");
                    System.out.print(rs.getString("Place") + " ");
                    System.out.print(rs.getString("Info") + " ");
                    System.out.println(rs.getString("transcation_id") + " ");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

