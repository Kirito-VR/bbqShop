package Shop.View.Good.Management;

import Shop.Bean.Good;
import Shop.Dao.GoodDaoImpl.GoodDaoImpl;
import Shop.Service.GoodServiceImpl.GoodServiceImpl;
import Shop.View.Main.mainView;
import Shop.util.ViewHandler;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 * @liwei
 */
public class goodManagement extends JFrame {
    public goodManagement()  {
        initComponents();}

    private void initComponents() {
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 =new JButton();
        button4 =new JButton();
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
        label1.setText("商品管理");
        contentPane.add(label1);
        label1.setBounds(460, 0, 600, 60);

        button1.setText("修改");
        contentPane.add(button1);
        button1.setBounds(320, 350, 100, 30);
        button1.addActionListener(
                (e)->{
                    int rowNo = table1.getSelectedRow();//获取所选的行号
                    String id=String.valueOf(table1.getValueAt(rowNo,0));
                    String name=String.valueOf(table1.getValueAt(rowNo,1));
                    Double price=(Double) table1.getValueAt(rowNo,2);

                    Good good=new Good(id,name,price);
                    goodUpdate change=new goodUpdate(good);
                    this.setVisible(false);
                    change.setVisible(true);
                }
        );
        button2.setText("添加");
        contentPane.add(button2);
        button2.setBounds(420, 350, 100, 30);
        button2.addActionListener(
                (e)->{
                    this.setVisible(false);
                    Good good=new Good();
                    goodInsert insert=new goodInsert();
                    insert.setVisible(true);
                }
        );

        button3.setText("删除");
        contentPane.add(button3);
        button3.setBounds(520, 350, 100, 30);
        button3.addActionListener(
                (e)->{
                    int rowNo = table1.getSelectedRow();//获取所选的行号
                    String id=String.valueOf(table1.getValueAt(rowNo,0));
                    GoodDaoImpl goodDao=new GoodDaoImpl();
                    goodDao.Remove(id);
                    this.setVisible(false);
                    goodManagement management=new goodManagement();
                    management.setVisible(true);
                }
        );

        button4.setText("完成");
        contentPane.add(button4);
        button4.setBounds(620, 350, 100, 30);
        button4.addActionListener(
                (e)->{
                    this.setVisible(false);
                    mainView main=new mainView();
                    main.setVisible(true);
                }
        );

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                ViewHandler.getMainView().setVisible(true);
            }
        });

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
        this.setBounds(200, 100, 1000, 415);
        this.setDefaultCloseOperation(2);
    }

    public Object[][] getDataFromDatabase() {

        List<Good> list = new GoodServiceImpl().Select(null);

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
    private JButton button3;
    private JButton button4;
    private JTextField textField1;
    private JLabel label1;

}
