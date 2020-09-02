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
            JOptionPane.showMessageDialog(rp , "恢复前请先配置正确的mysql路径");
            //跳转到配置mysqlPath路径
            MainPanel.instance.workingPanel.show(ConfigPanel.instance);
            //输入聚焦
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

        //弹出打开文件的对话框
        int returnVal = fc.showOpenDialog(rp);
        //获取选中的文件
        File file = fc.getSelectedFile();
        System.out.println(file);

        if(returnVal == JFileChooser.APPROVE_OPTION){
            //如果保存的文件没有以sql结尾
            System.out.println(file);
            if(!file.getName().toLowerCase().endsWith(".sql"))
            //new File(filePath, fileName)
                file = new File(file.getParentFile(), file.getName() + ".sql");
            System.out.println(file);

            try{
                MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
                JOptionPane.showMessageDialog(rp, "恢复成功");
            }catch(Exception e1){
                e1.printStackTrace();
                JOptionPane.showMessageDialog(rp, "恢复失败\r\n, 错误\r\n" + e1.getMessage());
            }
        }
    }
}
