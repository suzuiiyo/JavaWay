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

    public JLabel lSpend    = new JLabel("����(��)");
    public JLabel lCategory = new JLabel("����");
    public JLabel lComment  = new JLabel("��ע");
    public JLabel lDate     = new JLabel("����");

    // �����ı���
    public JTextField tfSpend = new JTextField("0");
    // ����������
    public CategoryComboBoxModel cbModel  = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);

    //��ע�ı���
    public JTextField tfComment = new JTextField();
    //���ڿؼ�
    public JXDatePicker datepick = new JXDatePicker(new Date());
    public JButton bSubmit = new  JButton("��һ��");

    private RecordPanel(){
        this.setLayout(new BorderLayout());

        lSpend.setFont(new Font("΢���ź�", Font.BOLD, 23));
        lCategory.setFont(new Font("΢���ź�", Font.BOLD, 23));
        lComment.setFont(new Font("΢���ź�", Font.BOLD, 23));
        lDate.setFont(new Font("΢���ź�", Font.BOLD, 23));

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
        //�����ࡱ����
        p.add(lCategory);
        //����������
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

    //��ȡComboBoxModelѡ�е�category
    public Category getSelectedCategory(){
        return (Category) cbCategory.getSelectedItem();
    }

    public void addListener(){
        RecordListener rl = new RecordListener();
        bSubmit.addActionListener(rl);
    }

    public void updateData(){
        //CategoryPanel��ӵķ���������ͨ��CategoryService��DAO�������ݸ�RecordPanel��ComboBoxModel��������ʾ
        cbModel.categorys = new CategoryService().list();
        //ˢ����ʾ
        cbCategory.updateUI();
        resetInput();
        tfSpend.grabFocus();
    }

    //��������
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