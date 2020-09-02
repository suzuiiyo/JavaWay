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
        //���
        r.setCid(c.getId());
        r.setComment(comment);
        r.setDate(date);
        System.out.println("recordDAO���յ���������:" + date);
        recordDao.add(r);
    }
}