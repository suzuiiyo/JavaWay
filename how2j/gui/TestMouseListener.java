package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestMouseListener {
    public static void main(String[] args) {
        final JFrame f = new JFrame("dota2");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);

        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("d:/Studio/JavaWay/AC/DC/Community.jpg");
        l.setIcon(i);
        l.setBounds(375, 275, i.getIconWidth(), i.getIconHeight());

        f.add(l);

        l.addMouseListener(new MouseListener() {
            //按下释放组合动作为点击鼠标
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }
            //按下鼠标
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }
            //释放鼠标
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }
            //鼠标进入
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }
            //鼠标退出
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}