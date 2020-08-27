package hutubill.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import hutubill.gui.panel.BackupPanel;
import hutubill.gui.panel.CategoryPanel;
import hutubill.gui.panel.ConfigPanel;
import hutubill.gui.panel.MainPanel;
import hutubill.gui.panel.RecordPanel;
import hutubill.gui.panel.RecoverPanel;
import hutubill.gui.panel.ReportPanel;
import hutubill.gui.panel.SpendPanel;

public class ToolBarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        MainPanel p = MainPanel.instance;
        JButton b = (JButton) e.getSource();
        if(b == p.bReport)
            p.workingPanel.show(ReportPanel.instance);
        if(b == p.bCategory)
            p.workingPanel.show(CategoryPanel.instance);
        if(b == p.bSpend)
            p.workingPanel.show(SpendPanel.instance);
        if(b == p.bRecord)
            p.workingPanel.show(RecordPanel.instance);
        if(b == p.bConfig)
            p.workingPanel.show(ConfigPanel.instance);
        if(b == p.bBackup)
            p.workingPanel.show(BackupPanel.instance);
        if(b == p.bRecover)
            p.workingPanel.show(RecoverPanel.instance);
    }
}