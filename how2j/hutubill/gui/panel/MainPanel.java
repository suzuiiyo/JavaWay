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
    //����ģʽ
    public static MainPanel instance = new MainPanel();

    public JToolBar tb       = new JToolBar();
    public JButton bSpend    = new JButton();
    public JButton bRecord   = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport   = new JButton();
    public JButton bConfig   = new JButton();
    public JButton bBackup   = new JButton();
    public JButton bRecover  = new JButton();
    //TODO  workingPanel����չʾ����ͼ����
    public CenterPanel workingPanel;

    //˽�л����췽��
    private MainPanel(){
        GUIUtil.setImageIcon(bSpend, "home.png", "����һ��");
        GUIUtil.setImageIcon(bRecord, "record.png", "��һ��");
        GUIUtil.setImageIcon(bCategory, "category2.png", "���ѷ���");
        GUIUtil.setImageIcon(bReport, "report.png", "�����ѱ���");
        GUIUtil.setImageIcon(bConfig, "config.png", "����");
        GUIUtil.setImageIcon(bBackup, "backup.png", "����");
        GUIUtil.setImageIcon(bRecover, "restore.png", "�ָ�");

        //��JToolBar�����JButton
        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        tb.setFloatable(false);
        
        workingPanel = new CenterPanel(0.8);

        //����MainPanel��setLayout����,BorderLayout����
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);

        //System.out.println(this);
        System.out.println(this.hashCode());

        //��Ӽ�������
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