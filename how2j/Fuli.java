public class Fuli{
    public static void main(String[] args){
        float fundPerYear=12000;
        float rate = 0.20f;
        int compoundInterest;
        int i;
        int j;
        int sum =0;
        for(i=1; i<100 ; i++) {
            int year = i;
            float fundRate = 1;
            for(j=0; j<year; j++)
                fundRate *= (1+rate);
            compoundInterest = (int)(fundPerYear*fundRate);
            sum += compoundInterest;
            System.out.println("经过" + year + "年， 总收入" + sum);
            if( sum > 1000000){
                System.out.println("一共需要" + year + "年，累计收入超过" + 1000000);
                break; 
            }
        }       
    }
}