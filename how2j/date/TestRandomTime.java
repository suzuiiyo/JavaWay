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
            date[i] = year + "��" + month + "��" + day + "��" + hour + "ʱ:" + minute + "��:" + second + "��";
            System.out.println(date[i]);
        }
    }
}