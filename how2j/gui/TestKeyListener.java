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

        //���Ӽ��̼���
        f.addKeyListener(new KeyListener(){
            //��������
            //��������
            //һ�����µ������϶���

            //һ�����µ������϶���
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                // TODO Auto-generated method stub

            }
            //��������
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                // TODO Auto-generated method stub

            }
            //��������
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                // TODO Auto-generated method stub
                //39��������"�Ҽ�"
                if(e.getKeyCode() == 39){
                    //ͼƬ�����ƶ�(y���겻��, x��������)
                    l.setLocation(l.getX()+10, l.getY());
                }
            }
        });
        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}