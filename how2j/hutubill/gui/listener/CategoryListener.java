package hutubill.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import hutubill.entity.Category;
import hutubill.gui.panel.CategoryPanel;
import hutubill.service.CategoryService;

public class CategoryListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        CategoryPanel cp = CategoryPanel.instance;

        JButton b = (JButton) e.getSource();
        /*if(b == cp.bAdd){
            JTextField tf = new JTextField();
            if(null != tf.getText()){
                cs.add(tf.getText());
            }
        }*/
        if(b == cp.bAdd){
            String name = JOptionPane.showInputDialog(null);
            if(null == name)
                return;
            if(0 == name.length()){
                JOptionPane.showMessageDialog(cp, "分类名称不能为空");
                return;
            }
            new CategoryService().add(name);
        }

        /*if(b == cp.bEdit){
            JTextField tf = new JTextField();
            if(null != tf.getText()){
                int id = cp.getSelectedCategory().getId();
                cs.update(id, tf.getName());
            }
        }*/

        if(b == cp.bEdit){
            Category c = cp.getSelectedCategory();
            int id = c.getId();
            String name = JOptionPane.showInputDialog("修改分类名称", c.getName());
            if(0 == name.length()){
                JOptionPane.showMessageDialog(cp, "分类名称不能为0");
                return;
            }
            new CategoryService().update(id, name);
        }

        /*if(b == cp.bDel){
            int id  = cp.getSelectedCategory().getId();
            Record record = rDao.get(id);
            if(null == record){
                JOptionPane.showMessageDialog(cp, "确定要删除吗？");
                cs.delete(id);
            }else{
                JOptionPane.showMessageDialog(cp, "记录非空不能删除");
            }
        }*/

        if(b == cp.bDel){
            Category c = cp.getSelectedCategory();
            if(0 != c.recordNumber){
                JOptionPane.showMessageDialog(cp, "本分类下有消费记录存在，不能删除");
                return;
            }
            if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(cp, "确认要删除?"))
                return;
            int id = c.getId();
            new CategoryService().delete(id);
        }
        cp.updateData();
    }
}