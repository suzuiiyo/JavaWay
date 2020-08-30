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
    //用于原型数据显示
    public CategoryComboBoxModel() {
        /*cs.add("餐饮");
        cs.add("交通");
        cs.add("住宿");
        cs.add("话费");
        c = cs.get(0);*/
        if(!categorys.isEmpty()){
            c = categorys.get(0);
        }
    }

    @Override
    public int getSize() {
        //TODO 获取下拉框的大小,就是前面定义的字符串集合的大小
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
        // TODO 当界面上选中了某一个下拉框项，就会调用这个方法
        c = (Category) anItem;

    }

    @Override
    public Object getSelectedItem() {
        // TODO Auto-generated method stub
        if(!categorys.isEmpty())
            return c;
        else
        //TODO   为什么为空返回null
            return null;
    }
}