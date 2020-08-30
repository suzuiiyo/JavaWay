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
        //Íâ¼ü
        r.setCid(c.getId());
        r.setComment(comment);
        r.setDate(date);
        recordDao.add(r);
    }
}