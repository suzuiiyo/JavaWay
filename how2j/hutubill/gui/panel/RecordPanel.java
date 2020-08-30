package hutubill.gui.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Date;
import java.util.List;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import hutubill.dao.CategoryDAO;
import hutubill.dao.RecordDAO;
import hutubill.entity.Category;
import hutubill.gui.listener.RecordListener;
import hutubill.gui.model.CategoryComboBoxModel;
import hutubill.service.CategoryService;
import hutubill.service.RecordService;

public class RecordPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static RecordPanel instance = new RecordPanel();

    public JLabel lSpend    = new JLabel("花费(￥)");
    public JLabel lCategory = new JLabel("分类");
    public JLabel lComment  = new JLabel("备注");
    public JLabel lDate     = new JLabel("日期");

    // 花费文本框
    public JTextField tfSpend = new JTextField("0");
    // 分类下拉框
    public CategoryComboBoxModel cbModel  = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);

    //备注文本框
    public JTextField tfComment = new JTextField();
    //日期控件
    public JXDatePicker datepick = new JXDatePicker(new Date());
    public JButton bSubmit = new  JButton("记一笔");

    private RecordPanel(){
        this.setLayout(new BorderLayout());

        lSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        lCategory.setFont(new Font("微软雅黑", Font.BOLD, 23));
        lComment.setFont(new Font("微软雅黑", Font.BOLD, 23));
        lDate.setFont(new Font("微软雅黑", Font.BOLD, 23));

        GUIUtil.setColor(ColorUtil.grayColor, lSpend, lCategory, lComment, lDate);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);


        this.add(pInput(), BorderLayout.NORTH);
        this.add(pSubmit(), BorderLayout.CENTER);

        addListener();
    }

    private JPanel pInput(){
        JPanel p = new JPanel();
        int gap = 40;
        p.setLayout(new GridLayout(4, 2, gap, gap));
        p.add(lSpend);
        p.add(tfSpend);
        //“分类”标题
        p.add(lCategory);
        //分类下拉栏
        p.add(cbCategory);

        p.add(lComment);
        p.add(tfComment);

        p.add(lDate);
        p.add(datepick);

        return p;
    }

    private JPanel pSubmit(){
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());

        p.add(bSubmit);
        return p;
    }

    //获取ComboBoxModel选中的category
    public Category getSelectedCategory(){
        return (Category) cbCategory.getSelectedItem();
    }

    public void addListener(){
        RecordListener rl = new RecordListener();
        bSubmit.addActionListener(rl);
    }

    public void updateData(){
        //CategoryPanel添加的分类名立即通过CategoryService的DAO操作传递给RecordPanel的ComboBoxModel下拉栏显示
        cbModel.categorys = new CategoryService().list();
        //刷新显示
        cbCategory.updateUI();
        resetInput();
        tfSpend.grabFocus();
    }

    //重置输入
    public void resetInput(){
        tfSpend.setText("0");
        tfComment.setText("");
        if(0!=cbModel.getSize())
            cbCategory.setSelectedIndex(0);
        datepick.setDate(new Date());
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecordPanel.instance);
    }
}