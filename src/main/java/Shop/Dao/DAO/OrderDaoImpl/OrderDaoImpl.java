package Shop.Dao.DAO.OrderDaoImpl;

import Shop.Bean.Order;
import Shop.Dao.OrderDao;
import Shop.util.ConnetionHandler;
import sun.net.ConnectionResetException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void updata(Order order) {
        remove(order);
        create(order);
    }
    @Override
    public void create(Order order) {
        Connection conn =null;
        PreparedStatement preparedStatement=null;
        try {//获取连接
            conn = ConnetionHandler.getConn();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            preparedStatement=conn.prepareStatement("insert into Order values(?,?,?,?,?);");
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

    @Override
    public void remove(Order order) {

    }

    @Override
    public void select(Order order) {

    }
}
