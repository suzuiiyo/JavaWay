package hutubill.gui.panel;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import hutubill.gui.listener.backupListener;
import hutubill.util.ColorUtil;
import hutubill.util.GUIUtil;

public class BackupPanel extends WorkingPanel{
    static{
        GUIUtil.useLNF();
    }

    public static BackupPanel instance = new BackupPanel();

    public JButton bBackup = new JButton("����");

    public BackupPanel(){
        GUIUtil.setColor(ColorUtil.blueColor, bBackup);
        //TODO  �˷�������JButton���JPanel��λ�ò�����
        /*this.setLayout(null);
        bBackup.setSize(60, 30);
        bBackup.setBounds((this.getWidth() - bBackup.getWidth())/2, (this.getHeight() - bBackup.getHeight())/2, bBackup.getWidth(), bBackup.getHeight());*/
        //TODO  ʹ��GroupLayout
        //this.setLayout(new GroupLayout(bBackup));
        this.add(bBackup);

        addListener();
    }

    public void addListener(){
        backupListener bl = new backupListener();
        bBackup.addActionListener(bl);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BackupPanel.instance);
    }

    @Override
    public void updateData() {
        // TODO Auto-generated method stub
    }
}