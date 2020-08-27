package hutubill.service;

import hutubill.dao.ConfigDAO;
import hutubill.entity.Config;

//TODO  ҵ�����ṩ��������
//TODO  1.��ʼ��  2.init(String key , String value)  3.get(String key)  4.update(String key, String value)
public class ConfigService {
    //��������,һ��Ԥ��һ��Mysql·��,������ζ�Ӧ���Ǵ������ݿ���,���Ի����init����������ʼ��
    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String default_budget = "500";

    static ConfigDAO dao = new ConfigDAO();
    static{
        init();
    }

    public static void init(){
        init(budget, default_budget);
        init(mysqlPath, "");
    }

    private static void init(String key, String value){
        Config config = dao.getByKey(key);
        if(config == null){
            Config c = new Config();
            c.setKey_(key);
            c.setValue(value);
            //�������� key��  value�����ݿ�Config��
            dao.add(c);
        }
    }

    public String get(String key){
        Config config = dao.getByKey(key);
        return config.getValue();
    }

    public void update(String key, String value){
        Config config = dao.getByKey(key);
        config.setValue(value);
        dao.update(config);
    }

    public int getIntBudget(){
        return Integer.parseInt(get(budget));
    }
}