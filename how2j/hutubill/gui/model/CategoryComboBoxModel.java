package hutubill.gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import hutubill.dao.CategoryDAO;
import hutubill.entity.Category;
import hutubill.service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel<Category> {
    //public List<String> cs = new ArrayList<>();
    public List<Category> categorys = new CategoryService().list();

    //String cate;
    public Category c;
    //����ԭ��������ʾ
    public CategoryComboBoxModel() {
        /*cs.add("����");
        cs.add("��ͨ");
        cs.add("ס��");
        cs.add("����");
        c = cs.get(0);*/
        if(!categorys.isEmpty()){
            c = categorys.get(0);
        }
    }

    @Override
    public int getSize() {
        //TODO ��ȡ������Ĵ�С,����ǰ�涨����ַ������ϵĴ�С
        return categorys.size();
    }

    @Override
    public Category getElementAt(int index){
        return categorys.get(index);
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
        c = (Category) anItem;

    }

    @Override
    public Object getSelectedItem() {
        // TODO Auto-generated method stub
        if(!categorys.isEmpty())
            return c;
        else
        //TODO   ΪʲôΪ�շ���null
            return null;
    }
}