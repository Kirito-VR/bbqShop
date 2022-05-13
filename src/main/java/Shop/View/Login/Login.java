/*
 * Created by JFormDesigner on Sat May 07 19:06:01 CST 2022
 */

package Shop.View.Login;

import Shop.View.Good.GoodMain;
import Shop.View.Main.mainView;
import Shop.View.Order.OrderMain;
import Shop.util.ConnectionHandler;
import Shop.util.ViewHandler;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Apr 02 15:41:52 CST 2022
 */


/**
 * @author 1
 */
public class Login extends JFrame {
    public Login() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField("cq");
        label2 = new JLabel();
        textField2 = new JTextField("guet1234");
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");

        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(115, 90), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(185, 85, 100, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(120, 125), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(185, 120, 100, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.addActionListener(
                (e) -> {

                    String username = textField1.getText();
                    String password = textField2.getText();

                    Connection conn = null;

                    String sql = "SELECT * FROM sys_user WHERE username= ? AND password=?;";

                    try {
                        conn = ConnectionHandler.getConn();

                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1,username);
                        pstmt.setString(2,password);
                        ResultSet rs = pstmt.executeQuery();
                        if (rs.next()) {//让游标向下移动一次
                            System.out.println("登录成1功");
                            this.setVisible(false);
                            mainView main =new mainView();
                            ViewHandler.setJframe(main);
                            main.setVisible(true);
//                            main.setVisible(true);
                        } else {
                            System.out.println("用户名或密码错误");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
        );
        button1.setText("\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(170, 185), button1.getPreferredSize()));


        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);//设置组件可见
    }

    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;

    public static void main(String[] args) {
        new Login();
    }
}