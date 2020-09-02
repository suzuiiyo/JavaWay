package hutubill.service;

import java.util.Date;

import hutubill.dao.RecordDAO;
import hutubill.entity.Category;
import hutubill.entity.Record;

public class RecordService {
    RecordDAO recordDao = new RecordDAO();
    public void add(int spend, Category c, String comment, Date date){
        Record r = new Record();
        r.setSpend(spend);
        //外键
        r.setCid(c.getId());
        r.setComment(comment);
        r.setDate(date);
        System.out.println("recordDAO接收到的日期是:" + date);
        recordDao.add(r);
    }
}