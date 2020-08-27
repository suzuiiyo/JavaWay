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
        jf.setTitle("一本糊涂账");
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加工具栏
        JToolBar tb = new JToolBar();
        // 添加按钮
        JButton bCoustom = new JButton("消费一览");
        JButton bRecord = new JButton("记一笔");
        JButton bCategory = new JButton("消费分类");
        JButton bReport = new JButton("月消费报表");
        JButton bConfig = new JButton("设置");
        JButton bBackup = new JButton("消费分类");
        JButton bRecover = new JButton("恢复");

        // 把Button添加到ToolBar
        tb.add(bCoustom);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        jf.setLayout(new BorderLayout());
        //添加JToolBar到JFrame
        jf.add(tb, BorderLayout.NORTH);
        //添加JPanel到JFrame
        jf.add(new JPanel(), BorderLayout.CENTER);
        //TODO 添加面板功能

        jf.setVisible(true);

        // 按钮的动作监听
        //TODO 各监听器增加功能
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