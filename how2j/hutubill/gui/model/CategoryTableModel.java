package hutubill.gui.model;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hutubill.entity.Category;
import hutubill.service.CategoryService;

public class CategoryTableModel implements TableModel {
    String[] columnNames = new String[] { "分类名称", "消费次数" };
    //TODO  用CategoryService的list方法获取消费记录降序排列的category
    public List<Category> categorys = new CategoryService().list();
    //List<String> cs = new ArrayList<>();

    //获取行数
    public int getRowCount(){
        return categorys.size();
    }
    //获取列数
    public int getColumnCount(){
        return columnNames.length;
    }


    /*public CategoryTableModel() {
        cs.add("餐饮");
        cs.add("交通");
        cs.add("住宿");
        cs.add("话费");
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return cs.size();
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnNames.length;
    }*/

    @Override
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return columnNames[columnIndex];
    }

    //返回列中所有单元格值的最特定超类
    //返回字段类类型,以便于显示出来
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // TODO Auto-generated method stub
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return false;
    }

    //先通过categorys.get(rowIndex)获取行对应的Category对象
    //然后根据columnIndex返回对应的属性
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        Category h = categorys.get(rowIndex);
        if(0==columnIndex)
            return h.getName();
        if(1==columnIndex)
            return h.recordNumber;

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub
    }
}