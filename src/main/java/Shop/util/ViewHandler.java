package Shop.util;

import Shop.View.Main.mainView;

import javax.swing.*;

/**
 * @Author: Cqmax
 * @Date: 2022/5/13 11:03
 * @Version 1.0
 */
public class ViewHandler {
    public static ThreadLocal<JFrame> jframe = new ThreadLocal<>();

    public static mainView getMainView(){
        mainView jf = null;
        jf = (mainView) jframe.get();
        if(jf==null){
            jf = new mainView();
            jframe.set(jf);

        }
        return jf;
    }

    public static void setJframe(mainView jf){
        jframe.set(jf);
    }

    public static void removeJframe(){
        jframe.remove();
    }
}
