package Shop.View.Order;

import Shop.Bean.OrderInfo;
import Shop.Dao.OrderInfoDao;
import Shop.Dao.OrderInfoDaoImpl.OrderInfoDaoImpl;
import com.sun.org.apache.xpath.internal.operations.Or;
import sun.plugin.dom.css.RGBColor;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author xm
 * 内容：创建界面，实现了订单详情修改内容
 */
public class OrderChange extends JFrame {
    public OrderInfo orderInfo;// 订单详情表传入
    public OrderChange(OrderInfo inputOrderInfo) {//初始化，传入参数
        this.orderInfo=inputOrderInfo;
        initComponents(this.orderInfo);
    }
    public OrderInfo backcalss(){
//        System.out.println(orderInfo.getQuantify());//测试输出返回用的
        return this.orderInfo;//返回对象
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
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8ba2\u5355\u4fee\u6539");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(165, 15), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5546\u54c1\u540d\u79f0\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(30, 70), label2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(95, 70, 65, textField1.getPreferredSize().height);
        textField1.setText(orderInfo.getOrderId());//设置商品名称

        //---- label3 ----
        label3.setText("\u5546\u54c1\u7f16\u53f7\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(215, 70), label3.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(275, 70, 65, textField2.getPreferredSize().height);//商品编号
        textField2.setText(orderInfo.getGoodId());

        //---- label4 ----
        label4.setText("\u5546\u54c1\u4ef7\u683c\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(30, 135), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u4fee\u6539\u6570\u91cf\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(220, 135), label5.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(280, 135, 65, textField3.getPreferredSize().height);
        contentPane.add(textField4);
        textField4.setBounds(95, 135, 65, textField4.getPreferredSize().height);//设置修改
        textField4.setText(orderInfo.getPrice()+"");
        //---- button1 ----//确认按钮
        button1.setText("\u786e\u8ba4");
        contentPane.add(button1);
        label6.setText("\u5df2\u4e0b\u5355\uff1a");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(30, 195), label6.getPreferredSize()));
        contentPane.add(textField5);
        textField5.setBounds(95, 195, 65, textField5.getPreferredSize().height);
        textField5.setText(orderInfo.getQuantify()+"");
        setVisible(true);
        setDefaultCloseOperation(3);
//        this.getContentPane().setBackground();
        button1.setBounds(new Rectangle(new Point(290, 235), button1.getPreferredSize()));
        button1.addActionListener( (e)->{
        // 修改订单
            orderInfo.setQuantify(Integer.parseInt(textField3.getText().replace(" ","")));
//            backcalss();//返回类，外部调用即可
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
