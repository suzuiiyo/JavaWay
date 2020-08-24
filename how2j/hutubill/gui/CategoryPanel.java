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

    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDel = new JButton("删除");

    //CategoryTableModel，参考前面的CategoryComboBoxModel
    public CategoryTableModel ctm = new CategoryTableModel();
    //用CategoryTableModel生成JTable   然后才能加到JScrollPane里
    public JTable t = new JTable(ctm);

    public CategoryPanel(){
        GUIUtil.setColor(ColorUtil.blueColor, bAdd, bEdit, bDel);
        //设置用户是否可以拖动列标题以重新排序列
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