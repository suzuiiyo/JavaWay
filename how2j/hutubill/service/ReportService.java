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
     * ��ȡĳһ������ѽ��
     * @param d
     * @param monthRawData
     * @return
     */

    //TODO  ��ȡĳһ������ѽ��ܶ�,��һ������ж��Record��Ҳ���ж��Spend�ϲ���һ��ó�daySpend
    public int getDaySpend(Date d, List<Record> monthRawData){
        int daySpend = 0;
        //List<Record> records = reDao.listThisMonth();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = sdf.format(d);
        for(Record r : monthRawData){
            //System.out.println("Date�����ڣ� " + DateUtil.util2sql(d));
            //System.out.println("Record�����ڣ� " + r.getDate());
            //ɸѡ��ͬһ��ü�¼
            //�������ڸ�ʽ��һ��sql.date��util.date���Ӽ�,��ʽ��һ�����бȽ�ɸѡ�����Ķ���0
            //util2sql����ת��Ҳ���� 
            //TODO   ������SDF���������ڶ�ת����String,Ȼ��Ƚ�String
            //if(r.getDate().equals(DateUtil.util2sql(d)))
            String dateMonthRawData = sdf.format(r.getDate());
            if(nowDate.equals(dateMonthRawData))
                daySpend += r.getSpend();
        }
        return daySpend;
    }

    /**
     * ��ȡһ���µ����Ѽ�¼����
     * @return
     */
    //��ȡһ������ÿ�����ѵþ�����
    //TODO   RecordDAO.listThisMonth()��ReportService.listThisMonthRecords()��ɶ����?
    //TODO   RecordDAO.listThisMonth()�ҳ����������е�Record������һ�����ж��Record
    //TODO   ReportService.listThisMonthRecords() �����ڽ�Record�ϲ����������ÿ���Spend��һ��ֻ��һ��Record
    public List<Record> listThisMonthPerDayRecords(){
        RecordDAO reDao = new RecordDAO();
        List<Record> result = new ArrayList<>();

        Date monthBegin = DateUtil.monthBegin();
        System.out.println(monthBegin);
        //Date monthEnd = DateUtil.monthEnd();
        //System.out.println(monthEnd);
        //����ÿ������м�¼
        List<Record> monthRawData = reDao.listThisMonth();
        System.out.println(monthRawData);

        int monthTotalDay = DateUtil.thisMonthTotalDay();
        System.out.println(monthTotalDay);
        //calendarʵ��
        Calendar c = Calendar.getInstance();
        for(int i=0; i<monthTotalDay; i++){
            Record r = new Record();
            //��ʱ������Ϊ�³�
            c.setTime(monthBegin);
            //����ʱ����i,�ͱ����Date������������˳��
            c.add(Calendar.DATE, i);
            Date eachDayOfThisMonth = c.getTime();
            int daySpend = getDaySpend(eachDayOfThisMonth, monthRawData);
            System.out.println("����" + DateUtil.util2sql(eachDayOfThisMonth) + "����" + daySpend);
            r.setSpend(daySpend);
            result.add(r);
        }
        return result;
    }

    /*
    //��ȡĳһ��������ܽ��  Date d
    //һ��monthList���ĳһ��
    //һ������кܶ�����¼
    //��ô�ж�record��ͬһ���, record��date����ͬ��
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