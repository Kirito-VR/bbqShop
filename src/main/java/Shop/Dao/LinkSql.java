package Shop.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: Cqmax
 * @Date: 2022/4/8 15:12
 * @Version 1.0
 */
public class LinkSql {

    private Connection conn =null;

    public LinkSql(String url,String user,String pass) throws  SQLException{
        this.conn = DriverManager.getConnection(url,user,pass);
        System.out.println(this.conn);
    }

    public Connection getConn() {
            return this.conn;
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/teashop?serverTimezone=UTC&useSSL=false";
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
