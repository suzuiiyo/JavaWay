package hutubill.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.util.ServiceConfigurationError;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import com.birosoft.liquid.FileChooserBasicUI;

import hutubill.gui.panel.ConfigPanel;
import hutubill.gui.panel.MainPanel;
import hutubill.gui.panel.RecoverPanel;
import hutubill.service.ConfigService;
import hutubill.util.MysqlUtil;

public class RecoverListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        RecoverPanel rp = RecoverPanel.instance;
        String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
        if(0 == mysqlPath.length()){
            JOptionPane.showMessageDialog(rp , "�ָ�ǰ����������ȷ��mysql·��");
            //��ת������mysqlPath·��
            MainPanel.instance.workingPanel.show(ConfigPanel.instance);
            //����۽�
            ConfigPanel.instance.tfMysqlPath.grabFocus();
        }            

        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("hutubill.sql"));
        fc.setFileFilter(new FileFilter(){

            @Override
            public boolean accept(File f) {
                // TODO Auto-generated method stub
                if(f.isDirectory())
                    return true;
                return f.getName().toLowerCase().endsWith(".sql");
            }

            @Override
            public String getDescription() {
                // TODO Auto-generated method stub
                return ".sql";
            }
        });

        //�������ļ��ĶԻ���
        int returnVal = fc.showOpenDialog(rp);
        //��ȡѡ�е��ļ�
        File file = fc.getSelectedFile();
        System.out.println(file);

        if(returnVal == JFileChooser.APPROVE_OPTION){
            //���������ļ�û����sql��β
            System.out.println(file);
            if(!file.getName().toLowerCase().endsWith(".sql"))
            //new File(filePath, fileName)
                file = new File(file.getParentFile(), file.getName() + ".sql");
            System.out.println(file);

            try{
                MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
                JOptionPane.showMessageDialog(rp, "�ָ��ɹ�");
            }catch(Exception e1){
                e1.printStackTrace();
                JOptionPane.showMessageDialog(rp, "�ָ�ʧ��\r\n, ����\r\n" + e1.getMessage());
            }
        }
    }
}
