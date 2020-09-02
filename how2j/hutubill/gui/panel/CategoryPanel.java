package hutubill.gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;

import hutubill.entity.Category;
import hutubill.gui.listener.CategoryListener;
import hutubill.service.CategoryService;
import hutubill.util.ColorUtil;
import hutubill.util.GUIUtil;
import hutubill.gui.model.CategoryTableModel;


public class CategoryPanel extends WorkingPanel{
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
        this.add(this.sp(t), BorderLayout.CENTER);
        this.add(this.pSubmit(), BorderLayout.SOUTH);

        //��Ӽ�����
        addListener();
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

    //�����ȡJTable�ϵ�ǰѡ�е�Category����
    public Category getSelectedCategory(){
        //��ȡ��������ѡ�е�category������
        int index = t.getSelectedRow();
        //TODO   ����������ctm��categorys�л�ȡcategory��ctm��category����CategoryService��list����ͨ��DAO��ȡ��
        return ctm.categorys.get(index);
    }

    //update���������������ӣ�ɾ�������޸�֮�󣬸��±���е���Ϣ����Ĭ��ѡ�е�һ��
    //���⣬�����жϣ���������û�����ݣ�ɾ�����޸İ�ť����ʹ��
    public void updateData(){
        ctm.categorys = new CategoryService().list();
        //ˢ����ʾ
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);

        //���tableΪ�գ���ֹɾ�����޸�
        if(0==ctm.categorys.size()){
            bEdit.setEnabled(false);
            bDel.setEnabled(false);
        }else{
            bEdit.setEnabled(true);
            bDel.setEnabled(true);
        }
    }

    public void addListener(){
        CategoryListener cl = new CategoryListener();
        bAdd.addActionListener(cl);
        bEdit.addActionListener(cl);
        bDel.addActionListener(cl);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(CategoryPanel.instance);
    }
}