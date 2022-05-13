package Shop.View.Stock;

import Shop.Bean.Order;
import Shop.Bean.Stock;
import Shop.Service.OrderService;
import Shop.Service.OrderServiceImpl.OrderServiceImpl;
import Shop.View.Good.GoodMain;
import Shop.View.Order_Info.OrderInfoView;
import Shop.util.ConnectionHandler;
import Shop.util.ViewHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockMain extends JFrame {
    public StockMain() {
        initComponents();
    }

    private void initComponents() {
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
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
        label1.setText("库存信息");
        contentPane.add(label1);
        label1.setBounds(435, 0, 600, 60);

        button1.setText("更新");
        contentPane.add(button1);
        button1.setBounds(335, 355, 100, 30);
        button1.addActionListener(
                (e)->{
                    String sql = "SELECT * FROM `stock`;";

                }
        );
        button2.setText("删除");
        contentPane.add(button2);
        button2.setBounds(440, 355, 100, 30);
        button2.addActionListener(
                (e)->{

                }
        );

        button3.setText("插入");
        contentPane.add(button3);
        button3.setBounds(545, 355, 100, 30);
        button3.addActionListener(
                (e)->{
                    int rowNo = table1.getSelectedRow();//获取所选的行号
                    int Id=(int) table1.getValueAt(rowNo, 0);
                    String Name = (String)table1.getValueAt(rowNo,1);
                    int Amount=(int)table1.getValueAt(rowNo, 2);
                    Double Cost= (Double)table1.getValueAt(rowNo,3);

                    System.out.println(Id);
                    System.out.println(Name);
                    System.out.println(Amount);
                    System.out.println(Cost);

                   /* UpdateStock updateStock = new UpdateStock(Stock);
                    updateStock.setVisible(true);*/

                }
        );
        button4.setText("退出");
        contentPane.add(button4);
        button4.setBounds(655, 355, 100, 30);
        button4.addActionListener(
                (e)->{
                    this.setVisible(false);

                }
        );
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                ViewHandler.getMainView().setVisible(true);
            }
        });

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

        java.util.List<Stock> list = new ArrayList<Stock>();
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "SELECT * FROM `stock`;";
        ResultSet rs = null;
        try {
            conn = ConnectionHandler.getConn();
            //pstmt = conn.createStatement();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Stock item = new Stock();
                item.setId(rs.getString(1));
                item.setName(rs.getString(2));
                item.setAmount(rs.getInt(3));
                item.setCost(rs.getDouble(4));
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
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getName();
                data[i][2] = list.get(i).getAmount();
                data[i][3] = list.get(i).getCost();
                //data[i][4] = list.get(i).getTransaction_id();

            }
        }
        return data;
    }

    private JScrollPane scrollPane1;
    private JTable table1;
    private String head[] = {"商品编号", "商品名称", "数量", "售价"};
    private Object[][] data = null;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    private JTextField textField1;
    private JLabel label1;

    public static void main(String[] args) {
        new Shop.View.Order.OrderMain();
    }
}