package Shop.Dao.GoodDaoImpl.CreateDao;

import Shop.Bean.Good;
import Shop.Dao.GoodDao;
import Shop.Dao.LinkSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * @Author: Cqmax
 * @Date: 2022/4/24 10:15
 * @Version 1.0
 */
public class CreateDaoImpl implements GoodDao {
    private Connection conn = null;

    public CreateDaoImpl() throws SQLException {
        String jdbc_url = "jdbc:mysql://60.205.221.125:3306/Good?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pass = "ShuXue_7";
        this.conn = new LinkSql(jdbc_url,user,pass).getConn();
    }

    public CreateDaoImpl(Connection conn) {
        this.conn = conn;
    }

    public void CreateGood(Good good) throws SQLException {
        String sqlMassage = "insert into good values(?,?,?);";

        // 读取good数据；

        PreparedStatement ppsttmt = conn.prepareStatement(sqlMassage);

        ppsttmt.setString(1,good.getGood_Id());
        ppsttmt.setString(2,good.getGood_name());
        ppsttmt.setFloat(3,good.getGood_price());



    }

    public void updata(Good good) {

    }

    public Map select(Map map) {
        return null;
    }

}
