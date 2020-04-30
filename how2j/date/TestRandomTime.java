package date;
import java.util.Random;

public class TestRandomTime {
    static Random rand = new Random();

    public static void main(String[] args) {
        String[] date = new String[365];
        for(int i=0; i<date.length; i++){
            String second = String.valueOf(rand.nextInt(60) + 1);
            String minute = String.valueOf(rand.nextInt(60) + 1);
            String hour = String.valueOf(rand.nextInt(12) + 1);
            String day = String.valueOf(rand.nextInt(31) + 1);
            String month = String.valueOf(rand.nextInt(12) + 1);
            String year = new String("1995");
            date[i] = year + "年" + month + "月" + day + "日" + hour + "时:" + minute + "分:" + second + "秒";
            System.out.println(date[i]);
        }
    }
}