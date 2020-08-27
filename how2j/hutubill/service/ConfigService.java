package hutubill.service;

import hutubill.dao.ConfigDAO;
import hutubill.entity.Config;

//TODO  业务类提供三个功能
//TODO  1.初始化  2.init(String key , String value)  3.get(String key)  4.update(String key, String value)
public class ConfigService {
    //两个数据,一个预算一个Mysql路径,无论如何都应该是存在数据库中,所以会调用init把他们俩初始化
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
            //插入数据 key，  value到数据库Config中
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