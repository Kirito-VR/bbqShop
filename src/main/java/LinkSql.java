import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: Cqmax
 * @Date: 2022/4/8 15:12
 * @Version 1.0
 */
public class LinkSql {
    public static void main(String[] args) {
        String url = "jdbc:mysql://60.205.221.125:3306/world?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pass = "ShuXue_7";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
