package Shop.Dao.OrderDaoImpl;

import Shop.Bean.Order;
import Shop.Dao.OrderDao;
import Shop.util.ConnectionHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ludh
 * @date 2022/5/3 15:51:46
 */
public class OrderDaoImpl implements OrderDao {
    @Override
    public void Updata(Order order) throws SQLException {
//        Remove(order);
//        Create(order);
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            //获取连接
            conn = ConnectionHandler.getConn();
            preparedStatement = conn.prepareStatement("UPDATE `Order` SET Aprice=? WHERE Oid = ? AND Info = '未完成';");
            preparedStatement.setDouble(1,order.getAprice() );
            preparedStatement.setString(2,order.getOid());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
        }
//        finally {
//            try {
//                conn.close();
//                preparedStatement.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }

    }

    //删除函数
    @Override
    public void Remove(Order order) throws SQLException {

        Connection conn = ConnectionHandler.getConn();
//        System.out.println("OrderDao:" + conn);
        try {
        String sql = "DELETE FROM `Order` WHERE Oid=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            Boolean bool;
            pstmt.setString(1,order.getOid());
            bool = pstmt.execute(sql);  //执行SQL语句


            //conn.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("删除失败");
        }

    }

    //查询函数
    @Override
    public List<Order> Select(Order order) throws SQLException {

        Connection conn = ConnectionHandler.getConn();
//        System.out.println("OrderDao:" + conn);
        List<Order> list = new ArrayList<>();
        try {
            if (order == null) {
                String sql = "select * from `Order` WHERE Info = ?;";
                PreparedStatement pstmt = null;
                ResultSet rs = null;

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,"未完成");
                //pstmt.setString(1,order.getOid());
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Order temp = new Order();
                    temp.setOid(rs.getString("Oid"));
                    temp.setAprice(rs.getDouble("Aprice"));
                    temp.setPlace(rs.getString("Place"));
                    temp.setInfo(rs.getString("Info"));
                    temp.setTransaction_id(rs.getString("transcation_id"));

                    list.add(temp);
                }
            }else {
                String sql = "select * from `Order` where oid=？AND Info = ?;";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = null;
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,order.getOid());
                pstmt.setString(2,"未完成");
                //pstmt.setString(1,order.getOid());

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Order temp = new Order();
                    temp.setOid(rs.getString("Oid"));
                    temp.setAprice(rs.getDouble("Aprice"));
                    temp.setPlace(rs.getString("Place"));
                    temp.setInfo(rs.getString("Info"));
                    temp.setTransaction_id(rs.getString("transcation_id"));
                    list.add(temp);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;

    }
}

