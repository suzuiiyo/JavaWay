package hutubill.gui.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Date;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import hutubill.gui.model.CategoryComboBoxModel;

public class RecordPanel extends JPanel {
    static {
        GUIUtil.useLNF();
    }

    public static RecordPanel instance = new RecordPanel();

    public JLabel lSpend = new JLabel("����(��)");
    public JLabel lCategory = new JLabel("����");
    public JLabel lComment = new JLabel("��ע");
    public JLabel lDate = new JLabel("����");

    //�����ı���
    public JTextField tfSpend = new JTextField("0");
    //����������
    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<String> cbCategory = new JComboBox<>(cbModel);

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
    }

    private JPanel pInput(){
        JPanel p = new JPanel();
        int gap = 40;
        p.setLayout(new GridLayout(4, 2, gap, gap));
        p.add(lSpend);
        p.add(tfSpend);

        p.add(lCategory);
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

    public static void main(String[] args) {
        GUIUtil.showPanel(RecordPanel.instance);
    }
}