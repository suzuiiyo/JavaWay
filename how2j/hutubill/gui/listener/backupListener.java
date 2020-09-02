package hutubill.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import hutubill.entity.Config;
import hutubill.gui.panel.BackupPanel;
import hutubill.gui.panel.ConfigPanel;
import hutubill.gui.panel.MainPanel;
import hutubill.service.ConfigService;
import hutubill.util.MysqlUtil;

public class backupListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        BackupPanel bp = BackupPanel.instance;

        //Config������ֵһ��budget,һ��mysqlPath
        //ConfigService.get(mysqlPath)�����ݿ���ȡ������Ӧ��·��ʱ,��˵��δ����mysql·��
        String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
        if(0==mysqlPath.length()){
            JOptionPane.showMessageDialog(bp, "����ǰ�������ú�mysql��·��");
            //��ʾ������塣��ʾ����mysql·��
            MainPanel.instance.workingPanel.show(ConfigPanel.instance);
            //�������۽�
            ConfigPanel.instance.tfMysqlPath.grabFocus();
            return;
        }
        //�ļ�ѡ����
        JFileChooser fc = new JFileChooser();
        //��ȡѡ�е��ļ�·��,ͬʱ�����ļ�hutubill.sql
        fc.setSelectedFile(new File("hutubill.sql"));
        //�ļ�������
        fc.setFileFilter(new FileFilter(){
            @Override
            public boolean accept(File f) {
                // TODO ������.sql��׺��β���ļ�
                //ֻ��ʾ��sql��β���ļ�
                //return f.getName().toLowerCase().endsWith(".sql");
                //TODO  ������  ֻҪĿ¼���ھͷ���true
                if(f.isDirectory()){
                    return true;
                }
                return f.getName().toLowerCase().endsWith(".sql");
            }

            @Override
            public String getDescription() {
                // TODO Auto-generated method stub
                return ".sql";
            }
        });

        //���������ļ��ĶԻ���
        int returnVal = fc.showSaveDialog(bp);
        File file = fc.getSelectedFile();
        System.out.println(file);

        //����õ���ѡ�е��ļ�
        if(returnVal == JFileChooser.APPROVE_OPTION){
            //���������ļ���û����.sql��β,�Զ�����.sql
            System.out.println(file);
            if(!file.getName().toLowerCase().endsWith(".sql"))
                file = new File(file.getParent(), file.getName() + ".sql");
            System.out.println(file);

            //��ȡ������ִ���κζ���
            try {
                MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
                JOptionPane.showMessageDialog(bp, "���ݳɹ��������ļ�λ�ڣ�\r\n" + file.getAbsolutePath());
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                JOptionPane.showMessageDialog(bp, "����ʧ��\r\n, ����:\r\n" + e1.getMessage());
            }
        }
    }
}
