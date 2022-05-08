package Shop.View.Good;

import Shop.Bean.Good;
import Shop.util.ConnectionHandler;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 * @liwei
 */
public class GoodMain extends JFrame {
    public GoodMain() {
        initComponents();
    }

    private void initComponents() {
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        // button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();

        DefaultTableModel tableModel = new DefaultTableModel(getDataFromDatabase(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table1.setModel(tableModel);

        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        label1.setFont(new
                Font("STHeiti Light", Font.BOLD,
                30));
        label1.setText("点单表");
        contentPane.add(label1);
        label1.setBounds(460, 0, 600, 60);

        button2.setText("添加");
        contentPane.add(button2);
        button2.setBounds(440, 355, 100, 30);
        button2.addActionListener(
                (e)->{
                    int rowNo = table1.getSelectedRow();//获取所选的行号
                    String id=(String)table1.getValueAt(rowNo, 0);
                    String name=(String)table1.getValueAt(rowNo, 1);
                    Double price=(Double)table1.getValueAt(rowNo, 2);

                    System.out.println(id);
                    System.out.println(name);
                    System.out.println(price);

                    Good good=new Good(id,name,price);
                    /*UpdateGood updateGood=new UpdateGood(good);
                    updateGood.setVisible(true);*/
                }
        );

        //contentPane.add(textField1);
        // textField1.setBounds(270, 355, 130, 30);
        scrollPane1.setViewportView(table1);
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 50, 1000, 300);
        {
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        //setLocationRelativeTo(getOwner());
        this.setBounds(200, 100, 1000, 415);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Object[][] getDataFromDatabase() {

        java.util.List<Good> list = new ArrayList<Good>();
        Connection conn = null;
       /* String user = "root";
        String dbPassword = "ShuXue_7";
        String url = "jdbc:mysql://60.205.221.125:3306/bbq?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";*/
        Statement stmt = null;
        String sql = "SELECT * FROM good";
        ResultSet rs = null;
        try {
            conn = ConnectionHandler.getConn();
            //conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Good good = new Good();
                good.setId(rs.getString(1));
                good.setName(rs.getString(2));
                good.setPrice(rs.getFloat(3));

                list.add(good);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        // 把集合的数据（商品信息）转换成二维数组
        data = new Object[list.size()][head.length];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getName();
                data[i][2] = list.get(i).getPrice();

            }
        }
        return data;
    }

    private JScrollPane scrollPane1;
    private JTable table1;
    private String head[] = {"id", "商品名称", "单价"};
    private Object[][] data = null;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private JLabel label1;

    public static void main(String[] args) {
        new GoodMain();
    }
}