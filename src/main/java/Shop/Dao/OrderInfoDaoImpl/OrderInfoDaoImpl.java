package Shop.Dao.OrderInfoDaoImpl;

import Shop.Bean.OrderInfo;
import Shop.Dao.OrderInfoDao;
import Shop.util.ConnectionHandler;
import com.mysql.cj.PreparedQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cqmax
 * @Date: 2022/5/4 21:35
 * @Version 1.0
 */
public class OrderInfoDaoImpl implements OrderInfoDao {
    @Override
    public void Create(OrderInfo orderInfo) throws SQLException {
        Connection conn = ConnectionHandler.getConn();
        String sql = "INSERT INTO OrderInfo Values(?,?,?,?,?,?);";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,orderInfo.getId());
            pstmt.setString(2,orderInfo.getOrderId());
            pstmt.setString(3,orderInfo.getGoodId());
            pstmt.setString(4,orderInfo.getGoodname());
            pstmt.setInt(5,orderInfo.getQuantify());
            pstmt.setDouble(6,orderInfo.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("数据添加失败！！");
        }
    }

    @Override
    public void Update(OrderInfo orderInfo) throws SQLException {
        Remove(orderInfo.getOrderId());
        try {
            Create(orderInfo);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("修改失败！！");
        }
    }

    @Override
    public List<OrderInfo> Select(OrderInfo OrderInfo) throws SQLException {

        Connection conn = ConnectionHandler.getConn();
        System.out.println("OrderInfoDao:" + conn);
        List<OrderInfo> list =new ArrayList<>();

        try {
            if (OrderInfo == null) {
                String sql = "select * from `OrderInfo` ";
                PreparedStatement pstmt = null;
                ResultSet rs = null;

                pstmt = conn.prepareStatement(sql);
                //pstmt.setString(1,OrderInfo.getOid());

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    OrderInfo orderInfo = new OrderInfo();
                    orderInfo.setId(rs.getString("ID"));
                    orderInfo.setOrderId(rs.getString("Oid"));
                    orderInfo.setGoodId(rs.getString("Gid"));
                    orderInfo.setGoodname(rs.getString("name"));
                    orderInfo.setQuantify(rs.getInt("Quantify"));
                    orderInfo.setPrice(rs.getDouble("Price"));
                    list.add(orderInfo);

                }
            }else {
                String sql = "select * from `OrderInfo` where oid=?;";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = null;
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,OrderInfo.getOrderId());
                //pstmt.setString(1,OrderInfo.getOid());

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    OrderInfo orderInfo = new OrderInfo();
                    orderInfo.setId(rs.getString("ID"));
                    orderInfo.setOrderId(rs.getString("Oid"));
                    orderInfo.setGoodId(rs.getString("Gid"));
                    orderInfo.setGoodname(rs.getString("name"));
                    orderInfo.setQuantify(rs.getInt("Quantify"));
                    orderInfo.setPrice(rs.getDouble("Price"));
                    list.add(orderInfo);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public List<OrderInfo> Select(String oid) throws SQLException {

        Connection conn = ConnectionHandler.getConn();
        System.out.println("OrderInfoDao:" + conn);
        List<OrderInfo> list =new ArrayList<>();

        try {
            String sql = "select * from `OrderInfo` where Oid=?";
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,oid);
            //pstmt.setString(1,OrderInfo.getOid());

            rs = pstmt.executeQuery();
            while (rs.next()) {
                OrderInfo orderInfo = new OrderInfo();
                orderInfo.setId(rs.getString("ID"));
                orderInfo.setOrderId(rs.getString("Oid"));
                orderInfo.setGoodId(rs.getString("Gid"));
                orderInfo.setQuantify(rs.getInt("Quantify"));
                orderInfo.setPrice(rs.getDouble("Price"));
                list.add(orderInfo);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
//        finally {
//            conn.close();
//        }
        return list;

    }
    @Override
    public void Remove(String id) throws SQLException {
        Connection conn = ConnectionHandler.getConn();
        String sql = "DELETE FROM OrderInfo where id=?;";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("删除失败！！");
        }
//        finally {
//            conn.close();
//        }
    }
}
