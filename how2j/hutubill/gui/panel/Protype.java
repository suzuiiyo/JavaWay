package hutubill.gui.panel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Protype {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(500, 450);
        jf.setTitle("һ����Ϳ��");
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ��ӹ�����
        JToolBar tb = new JToolBar();
        // ��Ӱ�ť
        JButton bCoustom = new JButton("����һ��");
        JButton bRecord = new JButton("��һ��");
        JButton bCategory = new JButton("���ѷ���");
        JButton bReport = new JButton("�����ѱ���");
        JButton bConfig = new JButton("����");
        JButton bBackup = new JButton("���ѷ���");
        JButton bRecover = new JButton("�ָ�");

        // ��Button��ӵ�ToolBar
        tb.add(bCoustom);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        jf.setLayout(new BorderLayout());
        //���JToolBar��JFrame
        jf.add(tb, BorderLayout.NORTH);
        //���JPanel��JFrame
        jf.add(new JPanel(), BorderLayout.CENTER);
        //TODO �����幦��

        jf.setVisible(true);

        // ��ť�Ķ�������
        //TODO �����������ӹ���
        bCoustom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        bCategory.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
        bReport.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
        bConfig.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
        bBackup.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
        bRecover.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
    }
}