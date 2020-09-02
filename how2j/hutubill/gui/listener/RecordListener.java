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
            JOptionPane.showMessageDialog(rp, "�����������Ѽ�¼");
            MainPanel.instance.workingPanel.show(SpendPanel.instance);
            return;
        }
        int spend = Integer.parseInt(rp.tfSpend.getText().trim());
        if(0 == spend){
            JOptionPane.showMessageDialog(rp, "����Ľ���Ϊ0");
        }else{
            new RecordService().add(spend, c, comment, d);
            JOptionPane.showMessageDialog(rp, "��ӳɹ�");
        }*/
        
        //��ȡComboBoxModel���category�б��size
        if(0 == rp.cbModel.getSize()){
            JOptionPane.showMessageDialog(rp, "�������ѷ��࣬����������ѷ���");
            MainPanel.instance.workingPanel.show(SpendPanel.instance);
            return;
        }

        if(!GUIUtil.checkZero(rp.tfSpend, "���ѽ��"))
            return;
        int spend = Integer.parseInt(rp.tfSpend.getText());
        //��ȡ��ǰѡ�е�category
        Category c = rp.getSelectedCategory();
        String comment = rp.tfComment.getText();
        Date d = rp.datepick.getDate();
        new RecordService().add(spend, c, comment, d);
        JOptionPane.showMessageDialog(rp, "��ӳɹ�");


        //��ת�� ����һ��
        MainPanel.instance.workingPanel.show(SpendPanel.instance);
    }
}