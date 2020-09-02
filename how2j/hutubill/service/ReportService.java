package hutubill.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hutubill.dao.RecordDAO;
import hutubill.entity.Record;
import hutubill.util.DateUtil;

public class ReportService {
    /**
     * 获取某一天得消费金额
     * @param d
     * @param monthRawData
     * @return
     */

    //TODO  获取某一天的消费金总额,这一天可能有多个Record，也就有多个Spend合并到一起得出daySpend
    public int getDaySpend(Date d, List<Record> monthRawData){
        int daySpend = 0;
        //List<Record> records = reDao.listThisMonth();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = sdf.format(d);
        for(Record r : monthRawData){
            //System.out.println("Date的日期： " + DateUtil.util2sql(d));
            //System.out.println("Record的日期： " + r.getDate());
            //筛选出同一天得记录
            //两个日期格式不一样sql.date是util.date的子集,格式不一样进行比较筛选出来的都是0
            //util2sql方法转换也不行 
            //TODO   必须用SDF方法将日期都转换成String,然后比较String
            //if(r.getDate().equals(DateUtil.util2sql(d)))
            String dateMonthRawData = sdf.format(r.getDate());
            if(nowDate.equals(dateMonthRawData))
                daySpend += r.getSpend();
        }
        return daySpend;
    }

    /**
     * 获取一个月的消费记录集合
     * @return
     */
    //获取一整个月每天消费得具体金额
    //TODO   RecordDAO.listThisMonth()和ReportService.listThisMonthRecords()有啥区别?
    //TODO   RecordDAO.listThisMonth()找出本月内所有的Record，可能一天内有多个Record
    //TODO   ReportService.listThisMonthRecords() 按日期将Record合并，并计算出每天的Spend，一天只有一个Record
    public List<Record> listThisMonthPerDayRecords(){
        RecordDAO reDao = new RecordDAO();
        List<Record> result = new ArrayList<>();

        Date monthBegin = DateUtil.monthBegin();
        System.out.println(monthBegin);
        //Date monthEnd = DateUtil.monthEnd();
        //System.out.println(monthEnd);
        //本月每天得所有记录
        List<Record> monthRawData = reDao.listThisMonth();
        System.out.println(monthRawData);

        int monthTotalDay = DateUtil.thisMonthTotalDay();
        System.out.println(monthTotalDay);
        //calendar实例
        Calendar c = Calendar.getInstance();
        for(int i=0; i<monthTotalDay; i++){
            Record r = new Record();
            //将时间设置为月初
            c.setTime(monthBegin);
            //加上时间量i,就变成了Date量，天数往后顺移
            c.add(Calendar.DATE, i);
            Date eachDayOfThisMonth = c.getTime();
            int daySpend = getDaySpend(eachDayOfThisMonth, monthRawData);
            System.out.println("今日" + DateUtil.util2sql(eachDayOfThisMonth) + "花费" + daySpend);
            r.setSpend(daySpend);
            result.add(r);
        }
        return result;
    }

    /*
    //获取某一天得消费总金额  Date d
    //一个monthList里得某一天
    //一天可能有很多条记录
    //怎么判断record是同一天的, record得date是相同得
    public int getDaySpend(Date d, List<Record> monthRecords){
        int getDaySpend = 0;
        for(Record r : monthRecords){
            if(r.getDate().equals(d)){
                getDaySpend += r.getSpend();
            }
        }
        return getDaySpend;
    }*/
}