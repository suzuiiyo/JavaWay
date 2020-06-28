package jdbc;

import java.util.List;

public interface DAO {
    //����
    public void add(HeroJDBC hero);
    //�޸�
    public void update(HeroJDBC hero);
    //ɾ��
    public void delete(int id);
    //��ȡ
    public HeroJDBC get(int id);
    //��ѯ
    public List<HeroJDBC> list();
    //��ҳ��ѯ
    public List<HeroJDBC> list(int start, int count);
}