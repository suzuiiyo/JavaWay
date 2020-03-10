public class GoldPoint{
    public static void main(String[] args){
        int range = 1000;
        float min = 1; //临界值
        float goldline=0.6180308f;
        int FenMu=0;
        int FenZi=0;
        for(int fenzi=1; fenzi<=range; fenzi++){
            for(int fenmu=1; fenmu<=range; fenmu++){
                if(0 == fenzi%2 && 0 == fenmu%2)
                    continue;
                float result = (float)fenzi/fenmu;
                float delta = result-goldline;
                delta=delta<0?0-delta:delta; //将delta转换为正数
                if(delta<min){
                    min=delta;
                    FenZi = fenzi;
                    FenMu = fenmu;
                }
            }
        }
        System.out.println("离黄金分割点(" + goldline +")最近的两个数相除是："  +FenZi+"/" + FenMu +"=" + ((float)FenZi/FenMu));
    }
}