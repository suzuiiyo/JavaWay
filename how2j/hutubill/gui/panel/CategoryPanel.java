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
        this.add(this.sp(t), BorderLayout.CENTER);
        this.add(this.pSubmit(), BorderLayout.SOUTH);

        //添加监听器
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

    //方便获取JTable上当前选中的Category对象
    public Category getSelectedCategory(){
        //获取下拉栏中选中的category的索引
        int index = t.getSelectedRow();
        //TODO   根据索引在ctm的categorys中获取category，ctm的category是由CategoryService的list方法通过DAO获取的
        return ctm.categorys.get(index);
    }

    //update方法，用于在增加，删除，和修改之后，更新表格中的信息，并默认选中第一行
    //另外，进行判断，如果表格中没有数据，删除和修改按钮不可使用
    public void updateData(){
        ctm.categorys = new CategoryService().list();
        //刷新显示
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);

        //如果table为空，禁止删除和修改
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