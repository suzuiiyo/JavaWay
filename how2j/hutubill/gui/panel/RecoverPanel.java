package hutubill.gui.panel;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RecoverPanel extends JPanel{
    static{
        GUIUtil.useLNF();
    }

    public static RecoverPanel instance = new RecoverPanel();

    public JButton bRecover = new JButton("�ָ�");

    public RecoverPanel(){
        GUIUtil.setColor(ColorUtil.blueColor, bRecover);
        //TODO  �˷�������JButton���JPanel��λ�ò�����
        /*this.setLayout(null);
        bBackup.setSize(60, 30);
        bBackup.setBounds((this.getWidth() - bBackup.getWidth())/2, (this.getHeight() - bBackup.getHeight())/2, bBackup.getWidth(), bBackup.getHeight());*/
        //TODO  ʹ��GroupLayout
        //this.setLayout(new GroupLayout(bBackup));
        this.add(bRecover);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }
}