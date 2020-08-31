package hutubill.service;

import java.util.List;

import hutubill.dao.RecordDAO;
import hutubill.database.DateUtil2;
import hutubill.entity.Record;
import hutubill.gui.panel.SpendPage;

public class SpendService {
    public SpendPage getSpendPage(){
        RecordDAO reDAO         = new RecordDAO();
        int       monthTotalDay = DateUtil2.monthTotalDay();
        int       monthLeftDay  = DateUtil2.monthLeftDay();

        List<Record> monthRecord = reDAO.listThisMonth();
        List<Record> todayRecord = reDAO.listToday();

        int monthSpend     = 0;
        int todaySpend     = 0;
        int avgSpendPerDay = 0;

        int budget         = new ConfigService().getIntBudget();
        int monthAvailable = 0;
        int dayAvgAvaible  = 0;
        int usagePercetage = 0;

        for(Record mr : monthRecord)
            monthSpend += mr.getSpend();

        avgSpendPerDay  = monthSpend / (monthTotalDay - monthLeftDay);
        monthAvailable  = budget - monthSpend;
        usagePercetage  = monthSpend * 100 /  budget;
        //注意月末最后一天0不要做分母
        if(monthLeftDay != 0)
            dayAvgAvaible = monthAvailable / monthLeftDay;
        else    
            dayAvgAvaible = (int)Double.POSITIVE_INFINITY;

        for(Record r : todayRecord)
            todaySpend += r.getSpend();

        return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvaible, monthLeftDay, usagePercetage);
    }
}