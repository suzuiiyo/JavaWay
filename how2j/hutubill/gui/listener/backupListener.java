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

        //Config两个键值一个budget,一个mysqlPath
        //ConfigService.get(mysqlPath)从数据库中取不出对应的路径时,即说明未配置mysql路径
        String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
        if(0==mysqlPath.length()){
            JOptionPane.showMessageDialog(bp, "备份前请先配置好mysql的路径");
            //显示配置面板。提示配置mysql路径
            MainPanel.instance.workingPanel.show(ConfigPanel.instance);
            //让输入框聚焦
            ConfigPanel.instance.tfMysqlPath.grabFocus();
            return;
        }
        //文件选择器
        JFileChooser fc = new JFileChooser();
        //获取选中的文件路径,同时创建文件hutubill.sql
        fc.setSelectedFile(new File("hutubill.sql"));
        //文件过滤器
        fc.setFileFilter(new FileFilter(){
            @Override
            public boolean accept(File f) {
                // TODO 过滤以.sql后缀结尾的文件
                //只显示以sql结尾的文件
                //return f.getName().toLowerCase().endsWith(".sql");
                //TODO  不过滤  只要目录存在就返回true
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

        //弹出保存文件的对话框
        int returnVal = fc.showSaveDialog(bp);
        File file = fc.getSelectedFile();
        System.out.println(file);

        //如果得到了选中的文件
        if(returnVal == JFileChooser.APPROVE_OPTION){
            //如果保存的文件名没有以.sql结尾,自动加上.sql
            System.out.println(file);
            if(!file.getName().toLowerCase().endsWith(".sql"))
                file = new File(file.getParent(), file.getName() + ".sql");
            System.out.println(file);

            //点取消不会执行任何动作
            try {
                MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
                JOptionPane.showMessageDialog(bp, "备份成功，备份文件位于：\r\n" + file.getAbsolutePath());
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                JOptionPane.showMessageDialog(bp, "备份失败\r\n, 错误:\r\n" + e1.getMessage());
            }
        }
    }
}
