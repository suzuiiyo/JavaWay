package hutubill.gui.panel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class CategoryTableModel implements TableModel {
    String[] columnNames = new String[] { "��������", "���Ѵ���" };
    List<String> cs = new ArrayList<>();

    public CategoryTableModel() {
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
    }

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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        if(0==columnIndex)
            return cs.get(rowIndex);
        if(1==columnIndex)
            return 0;
        if(2==columnIndex)
            return 1;
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