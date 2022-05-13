package Shop.View.Order_Info;

/**
 * @author ludh
 * @date 2022/5/8 17:12:54
 */

import Shop.Bean.Good;
import Shop.Bean.OrderInfo;
import Shop.Dao.OrderInfoDaoImpl.OrderInfoDaoImpl;
import Shop.Service.OrderInfoService;
import Shop.Service.OrderInfoServiceImpl.OrderInfoServiceImpl;
import Shop.Service.OrderService;
import Shop.Service.OrderServiceImpl.OrderServiceImpl;
import Shop.View.Good.GoodMain;
import Shop.View.Order.OrderChange;
import Shop.View.Order.OrderMain;
import Shop.util.ViewHandler;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class OrderInfoView extends JFrame {
    private String oid = null;
    public OrderInfoView() {
        initComponents();
    }

    public OrderInfoView(String oid){
        this.oid = oid;
        initComponents();
    }


    private void initComponents() {
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();

        DefaultTableModel tableModel = new DefaultTableModel(getDataFromDatabase(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table1.setModel(tableModel);

        setTitle("订单详情表");
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        label1.setFont(new Font("STHeiti Light", Font.BOLD, 30));
        label1.setText("订单详情表");
        contentPane.add(label1);
        label1.setBounds(460, 0, 600, 60);

        button1.setText("添加");
        contentPane.add(button1);
        button1.setBounds(100, 355, 100, 30);
        button1.addActionListener(
                (e)->{
                    this.setVisible(false);

                    GoodMain goodMain1 =new GoodMain(this.oid);
                    goodMain1.setVisible(true);

                }
        );

        button2.setText("修改");
        contentPane.add(button2);
        button2.setBounds(333, 355, 100, 30);
        button2.addActionListener(
                e -> {
                    int rowNo = table1.getSelectedRow();//获取所选的行号
                    String id=(String)table1.getValueAt(rowNo, 0);
                    String name=(String)table1.getValueAt(rowNo, 1);
                    Double price=(Double)table1.getValueAt(rowNo, 2);
//                    int amout = (int)table1.getValueAt(rowNo,3);
                    OrderInfo orderInfo = new OrderInfo();
                    orderInfo.setId(id);
                    orderInfo.setGoodname(name);
                    orderInfo.setPrice(price);
//                    orderInfo.getQuantify(amout);
                    try {
                        List<OrderInfo> list  = new OrderInfoServiceImpl().Select(id);
                        new OrderChange(orderInfo).setVisible(true);
                        this.dispose();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
        );

        button3.setText("删除");
        contentPane.add(button3);
        button3.setBounds(566, 355, 100, 30);
        button3.addActionListener(
                e -> {
                    int rowNo = table1.getSelectedRow();//获取所选的行号
                    String id=(String)table1.getValueAt(rowNo, 0);

                    try {
                        new OrderInfoDaoImpl().Remove(id);
                        this.dispose();
                        new OrderInfoView(this.oid).setVisible(true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
        );

        button4.setText("完成");
        contentPane.add(button4);
        button4.setBounds(800, 355, 100, 30);
        button4.addActionListener(
                e -> {
                    OrderService orderService = new OrderServiceImpl();
//                    orderService.Updata();
                    new OrderMain().setVisible(true);
                    this.setVisible(false);
                }
        );
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                ViewHandler.removeJframe();
                ViewHandler.getMainView().setVisible(true);
            }
        });


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
        this.setVisible(true);
        setLocationRelativeTo(getOwner());
        this.setBounds(200, 100, 1000, 415);
        this.setDefaultCloseOperation(2);
    }

    public Object[][] getDataFromDatabase() {

        List<OrderInfo> list = null;
        try {
            list = new OrderInfoServiceImpl().Select(oid);
            // 把集合的数据（商品信息）转换成二维数组
            data = new Object[list.size()][head.length];

            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < head.length; j++) {
                    data[i][0] = list.get(i).getId();
                    data[i][1] = list.get(i).getGoodname();
                    data[i][2] = list.get(i).getPrice();
                    data[i][3] = list.get(i).getQuantify();

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    private JScrollPane scrollPane1;
    private JTable table1;
    private String head[] = {"id", "商品名称", "单价" ,"数量"};
    private Object[][] data = null;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextField textField1;
    private JLabel label1;

    public static void main(String[] args) {
        new OrderInfoView();
    }
}