package hutubill.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import hutubill.gui.panel.ConfigPanel;
import hutubill.service.ConfigService;
import hutubill.util.GUIUtil;

public class ConfigListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO checkNumber方法有调用checkEmpty,进行判空
        ConfigPanel p = ConfigPanel.instance;
        //判断预算值是否为整数
        if(!GUIUtil.checkNumber(p.tfBudget, "本月预算"))
            return;
            //判断输入的路径是否正确。通过判断mysql.exe文件是否存在
        String mysqlPath = p.tfMysqlPath.getText();
        if (0 != mysqlPath.length()) {
            //判断mysqlPath/bin/路径下是否有mysql.exe
            File commandFile = new File(mysqlPath, "bin/mysql.exe");
            if (!commandFile.exists()) {
                JOptionPane.showMessageDialog(p, "Mysql路径不正确");
                //TODO  grabFocus让ConfigPanel的文本框tfMysqlPath一直处于输入状态，方便用于二次输入，否则要用鼠标点一下文本框才能再次输入
                p.tfMysqlPath.grabFocus();
                return;
            }
        }

        ConfigService cs = new ConfigService();
        cs.update(ConfigService.budget, p.tfBudget.getText());
        cs.update(ConfigService.mysqlPath, mysqlPath);

        JOptionPane.showMessageDialog(p, "设置修改成功");
    }
}
