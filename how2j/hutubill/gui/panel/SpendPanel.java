package hutubill.gui.panel;

import javax.swing.JLabel;

public class SpendPanel {
    //创建一个静态实例指向SpendPanel对象
    //按理来说，应该私有化类属性指向实例化对象
    //然后提供一个public方法，返回该类属性,从而达到获取对象的目的
    //八种甚至更多种单例模式
    public static SpendPanel instance = new SpendPanel();

    JLabel lMonthSpend = new JLabel("本月消费");
    JLabel lToday = new JLabel("今日消费");
    JLabel lAvgSpendPerDay = new JLabel("日均消费");
    JLabel lMonthLeft = new JLabel("本月剩余");
    JLabel lDayAvgAvailable = new JLabel("日均可用");
    JLabel lMonthLeftDay = new JLabel("距离月末");

    JLabel vMonthSpend = new JLabel("本月消费");
    JLabel vToday = new JLabel("今日消费");
    JLabel vAvgSpendPerDay = new JLabel("日均消费");
    JLabel vMonthLeft = new JLabel("本月剩余");
    JLabel vDayAvgAvailable = new JLabel("日均可用");
    JLabel vMonthLeftDay = new JLabel("距离月末");

    //私有化构造方法
    private SpendPanel(){
    }
}