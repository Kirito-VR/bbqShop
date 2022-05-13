/*
 * Created by JFormDesigner on Fri May 13 10:42:08 CST 2022
 */

package Shop.View.Main;

import Shop.View.Order.OrderMain;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class mainView extends JFrame {
    public mainView() {
        initComponents();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("订单管理");
        contentPane.add(button1);
        button1.setBounds(55, 60, 95, 45);
        button1.addActionListener(
                (e)->{
                    this.setVisible(false);
                    OrderMain ordermain  = new OrderMain();
                    ordermain.setVisible(true);

                }
        );

        //---- button2 ----
        button2.setText("商品管理");
        contentPane.add(button2);
        button2.setBounds(225, 60, 95, 45);


        //---- button3 ----
        button3.setText("库存管理");
        contentPane.add(button3);
        button3.setBounds(60, 160, 95, 45);

        //---- button4 ----
        button4.setText("人员管理");
        contentPane.add(button4);
        button4.setBounds(220, 150, 95, 45);

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
        setDefaultCloseOperation(3);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
