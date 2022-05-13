package Shop.View.Order;

import Shop.Bean.OrderInfo;
import Shop.Dao.OrderInfoDao;
import Shop.Dao.OrderInfoDaoImpl.OrderInfoDaoImpl;
import com.sun.org.apache.xpath.internal.operations.Or;
import sun.plugin.dom.css.RGBColor;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author xm
 * 内容：创建界面，实现了订单详情修改内容
 */
public class OrderChange extends JFrame {
    private OrderInfo orderInfo;// 订单详情表传入
    public OrderChange(OrderInfo inputOrderInfo) {//初始化，传入参数
        this.orderInfo=inputOrderInfo;
        initComponents(this.orderInfo);
    }
    public OrderInfo baccal(){
//        System.out.println(orderInfo);
        return orderInfo;//返回对象
    }
    private void initComponents(OrderInfo orderInfo) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        textField3 = new JTextField();
        textField4 = new JTextField();
        button1 = new JButton();
        label6 = new JLabel();
        textField5 = new JTextField();
        textField6=new JTextField();
        label7=new JLabel();
        label8=new JLabel();
        textField8=new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("修改界面");//顶部
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(165, 15), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("订单编号：");//订单编号
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(30, 70), label2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(95, 70, 65, textField1.getPreferredSize().height);
        textField1.setText(orderInfo.getOrderId()+"");//设置商品名称

        //---- label3 ----
        label3.setText("商品编号：");//商品id ok
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(215, 70), label3.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(275, 70, 65, textField2.getPreferredSize().height);//商品编号
        textField2.setText(orderInfo.getGoodId()+"");

        //---- label4 ----
        label4.setText("商品名称：");//商品名称 ok
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(30, 135), label4.getPreferredSize()));
        contentPane.add(textField4);
        textField4.setBounds(95, 135, 65, textField4.getPreferredSize().height);//设置修改
        textField4.setText(orderInfo.getGoodname()+"");


        //---- label5 ----
        label5.setText("商品价格：");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(220, 135), label5.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(280, 135, 65, textField3.getPreferredSize().height);
        textField3.setText(orderInfo.getPrice()+"");


        ///
        label6.setText("下单数量：");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(30, 195), label6.getPreferredSize()));
        contentPane.add(textField5);
        textField5.setBounds(95, 195, 65, textField5.getPreferredSize().height);
        textField5.setText(orderInfo.getQuantify()+"");


        contentPane.add(textField6);

        textField6.setBounds(280, 195, 65, textField5.getPreferredSize().height);
        textField6.setText(orderInfo.getId()+"");
        label7.setText("ID:");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(250, 195), label7.getPreferredSize()));


        label8.setText("修改数量：");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(30,250),label8.getPreferredSize()));
        contentPane.add(textField8);//修改数量
        textField8.setBounds(95, 250, 65, textField8.getPreferredSize().height);


        //---- button1 ----//确认按钮
        button1.setText("\u786e\u8ba4");
        contentPane.add(button1);
        setVisible(true);
        setDefaultCloseOperation(3);
        button1.setBounds(new Rectangle(new Point(270, 235), button1.getPreferredSize()));
        button1.addActionListener( (e)->{
        // 修改订单
            orderInfo.setQuantify(Integer.parseInt(textField8.getText().replace(" ","")));
            orderInfo.setOrderId(textField1.getText());
            orderInfo.setPrice(Double.parseDouble(textField3.getText().replace(" ","")));
            orderInfo.setGoodId(textField2.getText());
            orderInfo.setId(textField6.getText());
            orderInfo.setGoodname(textField4.getText());
            OrderInfoDao oid=new OrderInfoDaoImpl();
            try {
                oid.Update(orderInfo);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            textField5.setText("修改成功！");
        });
        //---- label6 ----
        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
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
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;//
    private JLabel label3;
    private JTextField textField2;//
    private JLabel label4;
    private JLabel label5;
    private JTextField textField3;//
    private JTextField textField4;//
    private JButton button1;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField5;//
    private JTextField textField6;//
    private JLabel label8;
    private JTextField textField8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
