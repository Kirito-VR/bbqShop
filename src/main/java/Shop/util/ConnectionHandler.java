package Shop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: Cqmax
 * @Date: 2022/5/3 12:17
 * @Version 1.0
 */
public class ConnectionHandler {
    public static ThreadLocal<Connection> connection = new ThreadLocal<>();
    public static Connection getConn() throws SQLException {
        String url = "jdbc:mysql://60.205.221.125:3306/bbq?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "ShuXue_7";
        Connection conn= null;
        conn = connection.get();
        if(conn==null){
            conn = DriverManager.getConnection(url,user,password);
            connection.set(conn);

        }
        return conn;
    }
    public static void connClose(){
        Connection conn = connection.get();
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
