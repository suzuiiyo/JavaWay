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
        //去除全部categorys
        List<Category> categorys = cateDAO.list();
        //TODO   消费分类的消费记录存在record里，根据消费分类的id取出消费记录后再赋值给消费分类的recordName属性
        for(Category cate : categorys){
            //根据每个分类的id,取出对应的消费记录的总数
            List<Record> rs = recordDAO.list(cate.getId());
            //将消费记录总数赋值给消费分类的recordName属性
            cate.recordNumber = rs.size();
        }
        //根据指定比较器引发的顺序对list进行排序
        //lambda表达式
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
        //TODO   直接调用DAO的add方法
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