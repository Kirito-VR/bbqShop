/*
 * Created by JFormDesigner on Fri May 13 13:30:15 CST 2022
 */

package Shop.View.Good.Management;

import Shop.Bean.Good;
import Shop.Dao.GoodDaoImpl.GoodDaoImpl;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class goodInsert extends JFrame {

    public goodInsert() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("商品编号");
        contentPane.add(label1);
        label1.setBounds(55, 50, 70, 25);
        contentPane.add(textField1);
        textField1.setBounds(135, 50, 100, textField1.getPreferredSize().height);
        textField1.setText("");

        //---- label2 ----
        label2.setText("商品名称");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(55, 100), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(135, 100, 100, textField2.getPreferredSize().height);
        textField2.setText("");

        //---- label3 ----
        label3.setText("\u5546\u54c1\u4ef7\u683c\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(55, 155), label3.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(135, 155, 100, textField3.getPreferredSize().height);
        textField3.setText("");

        //---- button1 ----
        button1.setText("\u786e\u8ba4");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(110, 215), button1.getPreferredSize()));
        button1.addActionListener(
                (e)->{
                    String id=textField1.getText();
                    String name=textField2.getText();
                    Double price=Double.parseDouble(textField3.getText());
                    Good good=new Good(id,name,price);
                    GoodDaoImpl goodDao=new GoodDaoImpl();
                    goodDao.Create(good);
                    this.setVisible(false);
                    goodManagement management=new goodManagement();
                    management.setVisible(true);
                }
        );
        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(200, 215), button2.getPreferredSize()));
        button2.addActionListener(
                (e)->{
                    this.setVisible(false);
                    goodManagement management=new goodManagement();
                    management.setVisible(true);
                }
        );
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setBounds(0,50,380,300);

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
