package hutubill.gui.panel;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import hutubill.gui.listener.RecoverListener;
import hutubill.util.ColorUtil;
import hutubill.util.GUIUtil;

public class RecoverPanel extends WorkingPanel{
    static{
        GUIUtil.useLNF();
    }

    public static RecoverPanel instance = new RecoverPanel();

    public JButton bRecover = new JButton("恢复");

    public RecoverPanel(){
        GUIUtil.setColor(ColorUtil.blueColor, bRecover);
        //TODO  此方法设置JButton相对JPanel的位置不可行
        /*this.setLayout(null);
        bBackup.setSize(60, 30);
        bBackup.setBounds((this.getWidth() - bBackup.getWidth())/2, (this.getHeight() - bBackup.getHeight())/2, bBackup.getWidth(), bBackup.getHeight());*/
        //TODO  使用GroupLayout
        //this.setLayout(new GroupLayout(bBackup));
        this.add(bRecover);

        addListener();
    }

    @Override
    public void addListener(){
        RecoverListener rl = new RecoverListener();
        bRecover.addActionListener(rl);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }

    @Override
    public void updateData() {
        // TODO Auto-generated method stub

    }
}