package hutubill.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class CategoryComboBoxModel implements ComboBoxModel<String> {
    public List<String> cs = new ArrayList<>();

    String c;

    //����ԭ��������ʾ
    public CategoryComboBoxModel() {
        cs.add("����");
        cs.add("��ͨ");
        cs.add("ס��");
        cs.add("����");
        c = cs.get(0);
    }

    @Override
    public int getSize() {
        //TODO ��ȡ������Ĵ�С,����ǰ�涨����ַ������ϵĴ�С
        return cs.size();
    }

    @Override
    public String getElementAt(int index) {
        // TODO ��ȡָ��λ�õ�����
        return cs.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setSelectedItem(Object anItem) {
        // TODO ��������ѡ����ĳһ����������ͻ�����������
        c = (String)anItem;

    }

    @Override
    public Object getSelectedItem() {
        // TODO Auto-generated method stub
        return c;
    }
}