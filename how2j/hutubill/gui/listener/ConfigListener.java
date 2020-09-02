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
        // TODO checkNumber�����е���checkEmpty,�����п�
        ConfigPanel p = ConfigPanel.instance;
        //�ж�Ԥ��ֵ�Ƿ�Ϊ����
        if(!GUIUtil.checkNumber(p.tfBudget, "����Ԥ��"))
            return;
            //�ж������·���Ƿ���ȷ��ͨ���ж�mysql.exe�ļ��Ƿ����
        String mysqlPath = p.tfMysqlPath.getText();
        if (0 != mysqlPath.length()) {
            //�ж�mysqlPath/bin/·�����Ƿ���mysql.exe
            File commandFile = new File(mysqlPath, "bin/mysql.exe");
            if (!commandFile.exists()) {
                JOptionPane.showMessageDialog(p, "Mysql·������ȷ");
                //TODO  grabFocus��ConfigPanel���ı���tfMysqlPathһֱ��������״̬���������ڶ������룬����Ҫ������һ���ı�������ٴ�����
                p.tfMysqlPath.grabFocus();
                return;
            }
        }

        ConfigService cs = new ConfigService();
        cs.update(ConfigService.budget, p.tfBudget.getText());
        cs.update(ConfigService.mysqlPath, mysqlPath);

        JOptionPane.showMessageDialog(p, "�����޸ĳɹ�");
    }
}
