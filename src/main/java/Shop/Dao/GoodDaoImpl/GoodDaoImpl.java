package Shop.Dao.GoodDaoImpl;

import Shop.Bean.Good;
import Shop.Dao.GoodDao;
import Shop.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author: Cqmax
 * @Date: 2022/5/3 14:18
 * @Version 1.0
 */
public class GoodDaoImpl implements GoodDao {
    @Override
    public void Updata(Good good) {

    }

    @Override
    public void Create(Good good) {
        Connection conn = null;
        try {
            conn = ConnectionHandler.getConn();
            String sql = "INSERT INTO good VALUES(?,?,?);";
            // id,name,price
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,good.getId());
            pstmt.setString(1,good.getName());
            pstmt.setDouble(1,good.getPrice());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void Remove(Good good) {

    }

    @Override
    public List<Good> Select(Good good) {
        Connection conn = null;
        List<Good> list = new ArrayList<>();
        try {

            conn = ConnectionHandler.getConn();
            if(good != null){
                String sql = "SELECT * FROM good WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,good.getId());
                ResultSet set = pstmt.executeQuery();
                while(set.next()){
                    Good temp = new Good();
                    temp.setId(set.getString("id"));
                    temp.setName(set.getString("name"));
                    temp.setPrice(set.getDouble("price"));
                    list.add(temp);
                }
                return list;

            }else {
                String sql = "SELECT * FROM good";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet set = pstmt.executeQuery();
                while(set.next()){
                    Good temp = new Good();
                    temp.setId(set.getString("id"));
                    temp.setName(set.getString("name"));
                    temp.setPrice(set.getDouble("price"));
                    list.add(temp);
                }
                return list;
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
