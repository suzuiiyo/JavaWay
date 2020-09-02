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
    //��System���ȡ��Ŀ¼
    static{
        imageFolder = System.getProperty("user.dir")+"\\how2j\\hutubill\\gui\\img";    //��ȡ��Ŀ��·��
    }

    //����ť����ͼ����ı��Լ���ʾ����
    public static void setImageIcon(JButton b, String fileName, String tip) {
        ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        b.setIcon(i);
        //Ԥ��ߴ�
        b.setPreferredSize(new Dimension(61, 81));
        //���ð�ť����˵��
        b.setToolTipText(tip);
        //���ִ�ֱ���֣�����ڰ�ť
        b.setVerticalTextPosition(JButton.BOTTOM);
        //����ˮƽ���֣�����ڰ�ť
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }

    //������������ǰ��ɫ
    public static void setColor(Color color, JComponent... cs) {
        for(JComponent c : cs){
            c.setForeground(color);
        }
    }

    public static void showPanel(JPanel p, double stretchRate){
        GUIUtil.useLNF();
        JFrame jf = new JFrame();
        jf.setSize(500, 500);
        //�Զ�������λ��
        jf.setLocationRelativeTo(null);
        //�������
        CenterPanel cp = new CenterPanel(stretchRate);
        jf.setContentPane(cp);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        //CenterPanel���show����, ���ղ���JComponet,JPanel��JComponent������
        cp.show(p);
    }

    public static void showPanel(JPanel p){
        showPanel(p, 0.85);
    }

    //�����������Ƿ������ָ�ʽ
    public static boolean checkNumber(JTextField tf, String input){
        if(!checkEmpty(tf, input))
            return false;
        String text = tf.getText().trim();
        try{
            Integer.parseInt(text);
            return true;
        }catch(NumberFormatException e1){
            JOptionPane.showMessageDialog(null, input + " ��Ҫ������");
            tf.grabFocus();
            return false;
        }
    }

    //����һ������������Ƿ�����
    public static boolean checkZero(JTextField tf, String input){
        if(!checkNumber(tf, input))
            return false;
        String text = tf.getText().trim();

        if(0 == Integer.parseInt(text)){
            JOptionPane.showMessageDialog(null, input + " ����Ϊ��");
            tf.grabFocus();
            return false;
        }
        return true;
    }
    //TODO parseInt������ı����+��-��,�ж������͸���
    //TODO �������������븺��
    public static boolean checkZero2(JTextField tf, String input){
        if(!checkNumber(tf, input))
            return false;
        String text = tf.getText().trim();
        //�ж�У�������Ƿ�Ϊ��Ч������
        if(Integer.parseInt(text) > 0){
            JOptionPane.showMessageDialog(null, input + " ��������ȷ������");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    //���һ������������Ƿ�Ϊ��
    public static boolean checkEmpty(JTextField tf, String input){
        String text = tf.getText().trim();
        if(0 == text.length()){
            JOptionPane.showMessageDialog(null, input + "����Ϊ��");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    public static int getInt(JTextField tf){
        return Integer.parseInt(tf.getText());
    }

    //ʹ��ˮ��Ƥ��
    public static void useLNF(){
        try{
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //��ӡͼ���ļ���Ŀ¼
    public static void main(String[] args) {
        System.out.println(imageFolder);
    }
}