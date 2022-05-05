
package Shop.Dao.DAO.OrderDaoImpl;

import Shop.Bean.Order;
import Shop.Dao.OrderDao;
import Shop.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void Updata(Order order) {
        Remove(order);
        Create(order);
    }
    @Override
    public void Create(Order order) {
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

    @Override
    public void Remove(Order order) {
        Connection conn = null;

        PreparedStatement preparedStatement = null;
        try {//获取连接
            conn = ConnectionHandler.getConn();
        }catch(SQLException e){
            throw new RuntimeException();
        }

        try{
            preparedStatement = conn.prepareStatement("delect from 'Order' where Oid=?");
            preparedStatement.setString(1, order.getOid());

            preparedStatement.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException();
        }finally{
            try{
                conn.close();
                preparedStatement.close();
            }catch(SQLException e) {
                throw new RuntimeException();
            }
        }
    }

    @Override
    public List<Order> Select(Order order) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try{
            conn = ConnectionHandler.getConn();

        } catch(SQLException e){
            throw new RuntimeException();
        }

        try{
            preparedStatement = conn.prepareStatement("select * from 'Order' where Oid=?");
            preparedStatement.setString(1,order.getOid());

            preparedStatement.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException();
        } finally{
            try{
                conn.close();
                preparedStatement.close();
            }catch(SQLException e){
                throw new RuntimeException();
            }
        }

    }
}