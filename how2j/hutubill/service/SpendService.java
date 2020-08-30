package hutubill.service;

import java.util.List;

import hutubill.dao.RecordDAO;
import hutubill.entity.Record;
import hutubill.gui.panel.SpendPage;

public class SpendService {
    public SpendPage getSpendPage(){
        RecordDAO reDAO = new RecordDAO();

        List<Record> monthRecord = reDAO.listThisMonth();
        List<Record> todayRecord = reDAO.listToday();

        int monthSpend     = 0;
        int todaySpend     = 0;
        int avgSpendPerDay = 0;

        int budget         = new ConfigService().getIntBudget();
        int monthAvailable = 0;
        int dayAvgAvaible  = 0;
        int monthLeftDay   = 0;
        int usagePercetage = 0;

        for(int i = 0; i< monthRecord.size(); i++){
            monthSpend     += monthRecord.get(i).getSpend();
            monthAvailable  = budget - monthSpend;
            monthLeftDay    = monthRecord.size() - i;
            usagePercetage  = monthSpend * 100 /  budget;
            dayAvgAvaible   = monthAvailable / monthLeftDay;
        }
        for(Record r : todayRecord){
            todaySpend += r.getSpend();
        }

        SpendPage sd = new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvaible, monthLeftDay, usagePercetage);
        return sd;
    }
}