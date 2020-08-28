package hutubill.service;

import java.util.Collections;
import java.util.List;

import hutubill.dao.CategoryDAO;
import hutubill.dao.RecordDAO;
import hutubill.entity.Category;
import hutubill.entity.Record;

public class CategoryService {
    CategoryDAO cateDAO = new CategoryDAO();
    RecordDAO recordDAO = new RecordDAO();

    public List<Category> list(){
        //ȥ��ȫ��categorys
        List<Category> categorys = cateDAO.list();
        //TODO   ���ѷ�������Ѽ�¼����record��������ѷ����idȡ�����Ѽ�¼���ٸ�ֵ�����ѷ����recordName����
        for(Category cate : categorys){
            //����ÿ�������id,ȡ����Ӧ�����Ѽ�¼������
            List<Record> rs = recordDAO.list(cate.getId());
            //�����Ѽ�¼������ֵ�����ѷ����recordName����
            cate.recordNumber = rs.size();
        }
        //����ָ���Ƚ���������˳���list��������
        //lambda���ʽ
        Collections.sort(categorys, (Category category1, Category category2) -> category2.recordNumber - category1.recordNumber);

        return categorys;
    }

    public void add(String name){
        /*try(Connection conn = DBUtil.getConn(); Statement s = conn.createStatement()){
            String sql = "insert into Category where name = " + name;
            s.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }*/
        //TODO   ֱ�ӵ���DAO��add����
        Category category = new Category();
        category.setName(name);
        cateDAO.add(category);
    }

    public void update(int id, String name){
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        cateDAO.update(category);
    }

    public void delete(int id){
        cateDAO.delete(id);
    }
}