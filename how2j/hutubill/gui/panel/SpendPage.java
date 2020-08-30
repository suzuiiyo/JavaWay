package hutubill.gui.panel;

public class SpendPage {
    public String monthSpend;
    public String todaySpend;
    public String avgSpendPerDay;
    public String monthAvailable;
    public String dayAvgAvailable;
    public String monthLeftDay;
    public int usagePercentage;
    public boolean isOverSpend = false;

    public SpendPage(int monthSpend, int todaySpend, int avgSpendPerDay, int monthAvailable, int dayAvgAvailable, int monthLeftDay, int usagePercentage){
        this.monthSpend = "гд" + monthSpend;
        this.todaySpend = "гд" + todaySpend;
        this.avgSpendPerDay = "гд" + avgSpendPerDay;
        if(monthAvailable < 0)
            isOverSpend = true;
        if(!isOverSpend){
            this.monthAvailable = "гд" + monthAvailable;
            this.dayAvgAvailable = "гд" + dayAvgAvailable;
        }

        this.monthLeftDay = monthLeftDay + "╠ь";
        this.usagePercentage = usagePercentage;
    }
}