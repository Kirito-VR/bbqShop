package Shop.View.Order;

import Shop.Bean.Order;
import Shop.Service.OrderService;
import Shop.Service.OrderServiceImpl.OrderServiceImpl;
import Shop.View.Good.GoodMain;
import Shop.View.Order_Info.OrderInfoView;
import Shop.util.ConnectionHandler;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.awt.*;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @wrl
 */

public class OrderMain extends JFrame {
    public OrderMain() {
        initComponents();
    }

    private void initComponents() {
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        //button4 = new JButton();
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
        label1.setText("订单信息");
        contentPane.add(label1);
        label1.setBounds(435, 0, 600, 60);

        button1.setText("新建");
        contentPane.add(button1);
        button1.setBounds(335, 355, 100, 30);
        button1.addActionListener(
                (e)->{

                    String Oid =String.valueOf(System.currentTimeMillis()).substring(0,10);
                    String Place = "三号桌";
                    System.out.println(Oid);
                    System.out.println(Place);
                    String Info = "未完成";


                    Order order = new Order(Oid,Place,1.0,Info);
                    OrderService orderService =new OrderServiceImpl();
                    try {
                        orderService.Create(order);
                        new GoodMain(Oid).setVisible(true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        System.out.println("添加失败");
                    }
                    /*UpdateOrder updateGood=new UpdateOrder(Order);
                    updateOrder.setVisible(true);*/
                }
        );
        button2.setText("修改");
        contentPane.add(button2);
        button2.setBounds(440, 355, 100, 30);
        button2.addActionListener(
                (e)->{
                    int rowNo = table1.getSelectedRow();//获取所选的行号
                    String Oid=(String) table1.getValueAt(rowNo, 0);
                    String Place = (String)table1.getValueAt(rowNo,1);
                    Double Aprice=(Double)table1.getValueAt(rowNo, 2);
                    String Info = (String)table1.getValueAt(rowNo,3);

                    System.out.println(Oid);
                    System.out.println(Place);
                    System.out.println(Aprice);
                    System.out.println(Info);




                    OrderInfoView orderInfo = new OrderInfoView();
                    /*UpdateOrder updateOrder = new UpdateOrder(Order);
                    updateOrder.setVisible(true);*/
                }
        );

        button3.setText("结账");
        contentPane.add(button3);
        button3.setBounds(545, 355, 100, 30);
        button3.addActionListener(
                (e)->{
                    
                }
        );


        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);//展示框
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
        //setLocationRelativeTo(getOwner());//显示界面框
        this.setBounds(300, 300, 1020, 450);
        this.setDefaultCloseOperation(2);
    }

    public Object[][] getDataFromDatabase() {

        //List<Order> list = new OrderServiceImpl().Select(null);

        java.util.List<Order> list = new ArrayList<Order>();
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "SELECT * FROM `Order`;";
        ResultSet rs = null;
        try {
            conn = ConnectionHandler.getConn();
            //pstmt = conn.createStatement();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Order item = new Order();
                item.setOid(rs.getString(1));
                item.setAprice(rs.getDouble(2));
                item.setPlace(rs.getString(3));
                item.setInfo(rs.getString(4));
                item.setTransaction_id(rs.getString(5));

                list.add(item);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        finally {
//            try {
//                rs.close();
//                pstmt.close();
//                conn.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//
//        }
        // 把集合的数据（订单信息）转换成二维数组
        data = new Object[list.size()][head.length];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getOid();
                data[i][1] = list.get(i).getPlace();
                data[i][2] = list.get(i).getAprice();
                data[i][3] = list.get(i).getInfo();
                //data[i][4] = list.get(i).getTransaction_id();

            }
        }
        return data;
    }

    private JScrollPane scrollPane1;
    private JTable table1;
    private String head[] = {"订单编号", "桌号", "总金额", "备注"};
    private Object[][] data = null;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    private JTextField textField1;
    private JLabel label1;

    public static void main(String[] args) {
        new OrderMain();
    }
}