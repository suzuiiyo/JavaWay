package hutubill.gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import hutubill.gui.listener.ToolBarListener;
import hutubill.util.GUIUtil;

public class MainPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }
    //单例模式
    public static MainPanel instance = new MainPanel();

    public JToolBar tb       = new JToolBar();
    public JButton bSpend    = new JButton();
    public JButton bRecord   = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport   = new JButton();
    public JButton bConfig   = new JButton();
    public JButton bBackup   = new JButton();
    public JButton bRecover  = new JButton();
    //TODO  workingPanel用于展示各种图，表
    public CenterPanel workingPanel;

    //私有化构造方法
    private MainPanel(){
        GUIUtil.setImageIcon(bSpend, "home.png", "消费一览");
        GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
        GUIUtil.setImageIcon(bCategory, "category2.png", "消费分类");
        GUIUtil.setImageIcon(bReport, "report.png", "月消费报表");
        GUIUtil.setImageIcon(bConfig, "config.png", "设置");
        GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
        GUIUtil.setImageIcon(bRecover, "restore.png", "恢复");

        //再JToolBar上添加JButton
        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        tb.setFloatable(false);
        
        workingPanel = new CenterPanel(0.8);

        //调用MainPanel的setLayout方法,BorderLayout布局
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);

        //System.out.println(this);
        System.out.println(this.hashCode());

        //添加监听方法
        addListener();
    }

    private void addListener(){
        ToolBarListener listener = new ToolBarListener();
        bSpend.addActionListener(listener);
        bRecord.addActionListener(listener);
        bCategory.addActionListener(listener);
        bReport.addActionListener(listener);
        bConfig.addActionListener(listener);
        bBackup.addActionListener(listener);
        bRecover.addActionListener(listener);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(MainPanel.instance, 1);
        //System.out.println(MainPanel.instance);
        System.out.println(MainPanel.instance.hashCode());
    }
}