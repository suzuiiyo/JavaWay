package hutubill.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }
    public static ConfigPanel instance = new ConfigPanel();

    public JLabel lBudget  = new JLabel("本月预算(￥)");
    public JTextField tf   = new JTextField();
    public JLabel lMysql   = new JLabel("Mysql安装目录");
    public JTextField tf2  = new JTextField();
    public JButton bSubmit = new JButton("更新");

    public ConfigPanel(){
        GUIUtil.setColor(ColorUtil.grayColor, lBudget, lMysql);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
        this.setLayout(new BorderLayout());
        this.add(pInput(), BorderLayout.NORTH);
        this.add(pSubmit(), BorderLayout.CENTER);
    }

    public JPanel pInput(){
        JPanel p = new JPanel();
        int gap = 40;
        p.setLayout(new GridLayout(4, 1, gap, gap));
        p.add(lBudget);
        p.add(tf);
        p.add(lMysql);
        p.add(tf2);
        return p;
    }

    public JPanel pSubmit(){
        JPanel b = new JPanel();
        b.add(bSubmit);
        return b;
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ConfigPanel.instance);
    }
}