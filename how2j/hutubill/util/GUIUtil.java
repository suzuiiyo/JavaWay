package hutubill.util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hutubill.gui.panel.CenterPanel;

public class GUIUtil {
    //private static String imageFolder = "d:/Studio/JavaWay/AC/DC/";
    private static String imageFolder;
    //用System类获取根目录
    static{
        imageFolder = System.getProperty("user.dir")+"\\how2j\\hutubill\\gui\\img";    //获取项目根路径
    }

    //给按钮设置图标和文本以及提示文字
    public static void setImageIcon(JButton b, String fileName, String tip) {
        ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        b.setIcon(i);
        //预设尺寸
        b.setPreferredSize(new Dimension(61, 81));
        //设置按钮文字说明
        b.setToolTipText(tip);
        //文字垂直布局，相对于按钮
        b.setVerticalTextPosition(JButton.BOTTOM);
        //文字水平布局，相对于按钮
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }

    //给多个组件设置前景色
    public static void setColor(Color color, JComponent... cs) {
        for(JComponent c : cs){
            c.setForeground(color);
        }
    }

    public static void showPanel(JPanel p, double stretchRate){
        GUIUtil.useLNF();
        JFrame jf = new JFrame();
        jf.setSize(500, 500);
        //自定义各组件位置
        jf.setLocationRelativeTo(null);
        //居中面板
        CenterPanel cp = new CenterPanel(stretchRate);
        jf.setContentPane(cp);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        //CenterPanel类的show方法, 接收参数JComponet,JPanel是JComponent的子类
        cp.show(p);
    }

    public static void showPanel(JPanel p){
        showPanel(p, 0.85);
    }

    //检查组件内容是否是数字格式
    public static boolean checkNumber(JTextField tf, String input){
        if(!checkEmpty(tf, input))
            return false;
        String text = tf.getText().trim();
        try{
            Integer.parseInt(text);
            return true;
        }catch(NumberFormatException e1){
            JOptionPane.showMessageDialog(null, input + " 需要是整数");
            tf.grabFocus();
            return false;
        }
    }

    //检验一个组件的内容是否是零
    public static boolean checkZero(JTextField tf, String input){
        if(!checkNumber(tf, input))
            return false;
        String text = tf.getText().trim();

        if(0 == Integer.parseInt(text)){
            JOptionPane.showMessageDialog(null, input + " 不能为零");
            tf.grabFocus();
            return false;
        }
        return true;
    }
    //TODO parseInt会解析文本里的+和-号,判断正数和负数
    //TODO 如果再输入框输入负数
    public static boolean checkZero2(JTextField tf, String input){
        if(!checkNumber(tf, input))
            return false;
        String text = tf.getText().trim();
        //判断校验内容是否为无效的输入
        if(Integer.parseInt(text) > 0){
            JOptionPane.showMessageDialog(null, input + " 请输入正确的数字");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    //检查一个输入框内容是否为空
    public static boolean checkEmpty(JTextField tf, String input){
        String text = tf.getText().trim();
        if(0 == text.length()){
            JOptionPane.showMessageDialog(null, input + "不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    public static int getInt(JTextField tf){
        return Integer.parseInt(tf.getText());
    }

    //使用水晶皮肤
    public static void useLNF(){
        try{
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //打印图标文件夹目录
    public static void main(String[] args) {
        System.out.println(imageFolder);
    }
}