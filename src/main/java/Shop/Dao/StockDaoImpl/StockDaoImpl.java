package Shop.Dao.StockDaoImpl;

import Shop.Bean.Stock;
import Shop.Dao.StockDao;
import Shop.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockDaoImpl implements StockDao{

    @Override
    public void Update(String good_id, int amount) throws SQLException {
        Connection conn=null;
        conn= ConnectionHandler.getConn();
        System.out.println("StockDao:" + conn);
        try {
            String sql="UPDATE Stock SET amount=amount-? WHERE good_id=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,good_id);
            pstmt.setInt(2,amount);

            pstmt.executeUpdate();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException("库存更新失败");
        }finally {
            ConnectionHandler.connClose();
        }
    }

    @Override
    public void Create(Stock stock) throws SQLException {
        Connection conn=null;
        try {
            conn= ConnectionHandler.getConn();
            String sql="INSERT INTO Stock VALUES(?,?,?,?)";
            PreparedStatement pstmt=conn.prepareStatement(sql);

            pstmt.setString(1, stock.getId());
            pstmt.setString(2, stock.getName());
            pstmt.setInt(3,stock.getAmount());
            pstmt.setDouble(4,stock.getCost());
            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException("新增库存失败");
        }finally {
            ConnectionHandler.connClose();
        }

    }

    @Override
    public void Select(String good_id) throws SQLException {
        Connection conn=null;
        try {
            conn=ConnectionHandler.getConn();
            String sql="SELECT * FROM Stock WHERE good_id=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,good_id);
            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException("库存中未找到该商品");
        }finally {
            ConnectionHandler.connClose();
        }

    }

    @Override
    public void Remove(String good_id) throws SQLException {
        Connection conn=null;
        try {
            conn=ConnectionHandler.getConn();
            String sql="DELETE *FROM Stock WHERE good_id=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,good_id);
            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException("该商品删除失败");
        }finally {
            ConnectionHandler.connClose();
        }
    }
}