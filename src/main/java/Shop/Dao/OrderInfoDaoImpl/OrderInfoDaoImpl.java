package Shop.Dao.OrderInfoDaoImpl;

import Shop.Bean.OrderInfo;
import Shop.Dao.OrderInfoDao;
import Shop.util.ConnectionHandler;

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
    public void Create(OrderInfo orderInfo) {
        
    }

    @Override
    public void Update(OrderInfo orderInfo) {

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
                    orderInfo.setQuantify(rs.getInt("Quantify"));
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
                    orderInfo.setQuantify(rs.getInt("Quantify"));
                    list.add(orderInfo);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public void Remove(OrderInfo orderInfo) {

    }
}
