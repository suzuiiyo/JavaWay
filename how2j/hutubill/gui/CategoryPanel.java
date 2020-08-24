package hutubill.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;


public class CategoryPanel extends JPanel{
    static{
        GUIUtil.useLNF();
    }

    public static CategoryPanel instance = new CategoryPanel();

    public JButton bAdd = new JButton("����");
    public JButton bEdit = new JButton("�༭");
    public JButton bDel = new JButton("ɾ��");

    //CategoryTableModel���ο�ǰ���CategoryComboBoxModel
    public CategoryTableModel ctm = new CategoryTableModel();
    //��CategoryTableModel����JTable   Ȼ����ܼӵ�JScrollPane��
    public JTable t = new JTable(ctm);

    public CategoryPanel(){
        GUIUtil.setColor(ColorUtil.blueColor, bAdd, bEdit, bDel);
        //�����û��Ƿ�����϶��б���������������
        t.getTableHeader().setReorderingAllowed(false);

        this.setLayout(new BorderLayout());
        this.add(sp(t), BorderLayout.CENTER);
        this.add(pSubmit(), BorderLayout.SOUTH);
    }

    private JScrollPane sp(JTable t){
        JScrollPane p = new JScrollPane(t);
        p.setLayout(new ScrollPaneLayout());
        return p;
    }

    private JPanel pSubmit(){
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 3));
        p.add(bAdd);
        p.add(bEdit);
        p.add(bDel);
        return p;
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(CategoryPanel.instance);
    }
}