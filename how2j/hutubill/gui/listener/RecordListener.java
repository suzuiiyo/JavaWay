package hutubill.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import hutubill.entity.Category;
import hutubill.gui.panel.MainPanel;
import hutubill.gui.panel.RecordPanel;
import hutubill.gui.panel.SpendPanel;
import hutubill.service.RecordService;
import hutubill.util.GUIUtil;

public class RecordListener implements ActionListener {
    @Override
	public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        RecordPanel rp = RecordPanel.instance;

        /*List<Category> cs = new CategoryService().list();
        Category c = cs.get(0);
        String comment = rp.tfComment.getText();
        Date d =  rp.datepick.getDate();
        if(cs.isEmpty()){
            JOptionPane.showMessageDialog(rp, "请先增加消费记录");
            MainPanel.instance.workingPanel.show(SpendPanel.instance);
            return;
        }
        int spend = Integer.parseInt(rp.tfSpend.getText().trim());
        if(0 == spend){
            JOptionPane.showMessageDialog(rp, "输入的金额不能为0");
        }else{
            new RecordService().add(spend, c, comment, d);
            JOptionPane.showMessageDialog(rp, "添加成功");
        }*/
        
        //获取ComboBoxModel里的category列表的size
        if(0 == rp.cbModel.getSize()){
            JOptionPane.showMessageDialog(rp, "暂无消费分类，请先添加消费分类");
            MainPanel.instance.workingPanel.show(SpendPanel.instance);
            return;
        }

        if(!GUIUtil.checkZero(rp.tfSpend, "花费金额"))
            return;
        int spend = Integer.parseInt(rp.tfSpend.getText());
        //获取当前选中的category
        Category c = rp.getSelectedCategory();
        String comment = rp.tfComment.getText();
        Date d = rp.datepick.getDate();
        new RecordService().add(spend, c, comment, d);
        JOptionPane.showMessageDialog(rp, "添加成功");


        //跳转到 消费一览
        MainPanel.instance.workingPanel.show(SpendPanel.instance);
    }
}