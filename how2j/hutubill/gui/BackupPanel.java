package hutubill.gui;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BackupPanel extends JPanel{
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
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BackupPanel.instance);
    }
}