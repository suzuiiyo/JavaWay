package gui;

import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestKeyListener {
    public static void main(String[] args) {
        JFrame f = new JFrame("dota2");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("d:/Studio/JavaWay/AC/DC/community.jpg");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        //增加键盘监听
        f.addKeyListener(new KeyListener(){
            //键被弹起
            //键被按下
            //一个按下弹起的组合动作

            //一个按下弹起的组合动作
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                // TODO Auto-generated method stub

            }
            //键被按下
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                // TODO Auto-generated method stub

            }
            //键被弹起
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                // TODO Auto-generated method stub
                //39代表按下了"右键"
                if(e.getKeyCode() == 39){
                    //图片向右移动(y坐标不变, x坐标增加)
                    l.setLocation(l.getX()+10, l.getY());
                }
            }
        });
        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}