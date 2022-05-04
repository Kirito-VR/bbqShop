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
        }
    }

    @Override
    public void Create(Stock stock) {

    }

    @Override
    public void Select(String good_id) {

    }

    @Override
    public void Remove(String good_id) {

    }
}