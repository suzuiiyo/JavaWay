package hutubill.gui.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import hutubill.service.SpendService;
import hutubill.util.ColorUtil;
import hutubill.util.GUIUtil;


public class SpendPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static SpendPanel instance = new SpendPanel();

    public JLabel lMonthSpend = new JLabel("本月消费");
    public JLabel lTodaySpend = new JLabel("今日消费");
    public JLabel lAvgSpendPerDay = new JLabel("日均消费");
    public JLabel lMonthLeft = new JLabel("本月剩余");
    public JLabel lDayAvgAvailable = new JLabel("日均可用");
    public JLabel lMonthLeftDay = new JLabel("距离月末");

    public JLabel vMonthSpend = new JLabel();
    public JLabel vTodaySpend = new JLabel();
    public JLabel vAvgSpendPerDay = new JLabel();
    public JLabel vMonthAvailable = new JLabel();
    public JLabel vDayAvgAvailable = new JLabel();
    public JLabel vMonthLeftDay = new JLabel();

    CircleProgressBar bar;

    private SpendPanel(){
        this.setLayout(new BorderLayout());
        bar =  new CircleProgressBar();
        bar.setBackgroundColor(ColorUtil.blueColor);

        GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, 
                lMonthLeft, lDayAvgAvailable, lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable,
                vMonthLeftDay);
        
        GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);

        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));

        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
    }

    //center里面套了一个center2就是环形进度条
    private JPanel center(){
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(west(), BorderLayout.WEST);
        p.add(center2(), BorderLayout.CENTER);

        return p;
    }

    private Component center2() {
        return bar;
    }

    private Component west() {
        JPanel p = new JPanel();
        //网格布局,四行一列
        p.setLayout(new GridLayout(4, 1));

        p.add(lMonthSpend);
        p.add(vMonthSpend);
        p.add(lTodaySpend);
        p.add(vTodaySpend);
        return p;
    }

    private JPanel south(){
        JPanel p = new JPanel();
        //网格布局，两行四列
        p.setLayout(new GridLayout(2, 4));

        p.add(lAvgSpendPerDay);
        p.add(lMonthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMonthAvailable);
        p.add(vDayAvgAvailable);
        p.add(vMonthLeftDay);

        return p;
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(SpendPanel.instance);
        SpendPage sd = new SpendService().getSpendPage();
        System.out.println(sd.todaySpend);
    }

    @Override
    public void updateData() {
        // TODO Auto-generated method stub
        SpendPage sd = new SpendService().getSpendPage();
        vMonthSpend.setText(sd.monthSpend);
        vTodaySpend.setText(sd.todaySpend);    
        vAvgSpendPerDay.setText(sd.avgSpendPerDay);
        vMonthAvailable.setText(sd.monthAvailable);
        vDayAvgAvailable.setText(sd.dayAvgAvailable);
        vMonthLeftDay.setText(sd.monthLeftDay);

        //进度条设置进度
        bar.setProgress(sd.usagePercentage);
        if(sd.isOverSpend){
            vMonthAvailable.setForeground(ColorUtil.warningColor);
            vMonthSpend.setForeground(ColorUtil.warningColor);
            vTodaySpend.setForeground(ColorUtil.warningColor);
        }else{
            vMonthAvailable.setForeground(ColorUtil.grayColor);
            vMonthSpend.setForeground(ColorUtil.blueColor);
            vTodaySpend.setForeground(ColorUtil.blueColor);
        }
        //进度条变色
        bar.setForegroundColor(ColorUtil.getByPercentage(sd.usagePercentage));
    }

    @Override
    public void addListener() {
        // TODO Auto-generated method stub
    }
}