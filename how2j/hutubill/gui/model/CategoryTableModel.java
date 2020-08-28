package hutubill.gui.model;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hutubill.entity.Category;
import hutubill.service.CategoryService;

public class CategoryTableModel implements TableModel {
    String[] columnNames = new String[] { "��������", "���Ѵ���" };
    //TODO  ��CategoryService��list������ȡ���Ѽ�¼�������е�category
    public List<Category> categorys = new CategoryService().list();
    //List<String> cs = new ArrayList<>();

    //��ȡ����
    public int getRowCount(){
        return categorys.size();
    }
    //��ȡ����
    public int getColumnCount(){
        return columnNames.length;
    }


    /*public CategoryTableModel() {
        cs.add("����");
        cs.add("��ͨ");
        cs.add("ס��");
        cs.add("����");
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

    //�����������е�Ԫ��ֵ�����ض�����
    //�����ֶ�������,�Ա�����ʾ����
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

    //��ͨ��categorys.get(rowIndex)��ȡ�ж�Ӧ��Category����
    //Ȼ�����columnIndex���ض�Ӧ������
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