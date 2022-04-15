package Shop.goodList.updata;


import Shop.LinkSql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Cqmax
 * @Date: 2022/4/14 21:56
 * @Version 1.0
 */
public class InsertGoods {
    // 获得信息并加入数据库；
    private Statement sttmt = null;

    public InsertGoods() {
        String url = "jdbc:mysql://60.205.221.125:3306/shopProject?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8";
        String user ="root";
        String pass = "ShuXue_7";
        try {
            this.sttmt = new LinkSql(url,user,pass).getConn().createStatement();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }
    }

    public void InsertMessage(String ID,String name,int store,double price,double buy){
        String  Message = "INSERT INTO Good VALUES('"+ID+"','"+name+"',"+store+","+price+","+buy+")";
        System.out.println(Message);
        try {
            this.sttmt.execute(Message);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new InsertGoods().InsertMessage("1004","猪鞭",100,5.0,3.0);
    }
}
