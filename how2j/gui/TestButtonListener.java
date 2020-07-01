package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestButtonListener {
    public static void main(String[] args) {
        JFrame f = new JFrame("dota2");
        f.setSize(355, 455);
        f.setLocationRelativeTo(null);
        f.setLayout(null);

        JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("d:/Studio/JavaWay/AC/DC/Community/jpg");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        JButton b = new JButton("����ͼƬ");
        b.setBounds(150, 200, 100 ,30);

        //����ť���Ӽ���
        b.addActionListener(new ActionListener(){

            //����ť�����ʱ���ͻᴥ��ActionEvent�¼�
            //actionPerformed �����ͻᱻִ��
            boolean hide = false;
            public void actionPerformed(ActionEvent e){
                l.setVisible(hide);
                hide = !hide;
                b.setText(hide?"��ʾͼƬ":"����ͼƬ");
            }
        });
        //����ť�����ʱ,�ͻᴥ��ActionEventʱ��
        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}