package hutubill.gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hutubill.gui.listener.ConfigListener;
import hutubill.service.ConfigService;
import hutubill.util.ColorUtil;
import hutubill.util.GUIUtil;

public class ConfigPanel extends WorkingPanel{
    static{
        GUIUtil.useLNF();
    }
    public static ConfigPanel instance = new ConfigPanel();

    public JLabel lBudget         = new JLabel("本月预算(￥)");
    public JTextField tfBudget    = new JTextField();
    public JLabel lMysqlPath      = new JLabel("Mysql安装目录");
    public JTextField tfMysqlPath = new JTextField();
    public JButton bSubmit        = new JButton("更新");

    public ConfigPanel(){
        GUIUtil.setColor(ColorUtil.grayColor, lBudget, lMysqlPath);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
        this.setLayout(new BorderLayout());
        this.add(pInput(), BorderLayout.NORTH);
        this.add(pSubmit(), BorderLayout.CENTER);

        //添加监听器
        addListener();
    }

    public JPanel pInput(){
        JPanel p = new JPanel();
        int gap = 40;
        p.setLayout(new GridLayout(4, 1, gap, gap));
        p.add(lBudget);
        p.add(tfBudget);
        p.add(lMysqlPath);
        p.add(tfMysqlPath);
        return p;
    }

    public JPanel pSubmit(){
        JPanel b = new JPanel();
        b.add(bSubmit);
        return b;
    }

    public void addListener(){
        ConfigListener cl = new ConfigListener();
        bSubmit.addActionListener(cl);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ConfigPanel.instance);
    }

    //把数据库里的数据取出来 显示在面板上
    @Override
    public void updateData() {
        // TODO Auto-generated method stub
        String budget = new ConfigService().get(ConfigService.budget);
        String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
        tfBudget.setText(budget);
        tfMysqlPath.setText(mysqlPath);
        tfBudget.grabFocus();
    }
}