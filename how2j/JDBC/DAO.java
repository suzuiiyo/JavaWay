package jdbc;

import java.util.List;

public interface DAO {
    //增加
    public void add(HeroJDBC hero);
    //修改
    public void update(HeroJDBC hero);
    //删除
    public void delete(int id);
    //获取
    public HeroJDBC get(int id);
    //查询
    public List<HeroJDBC> list();
    //分页查询
    public List<HeroJDBC> list(int start, int count);
}