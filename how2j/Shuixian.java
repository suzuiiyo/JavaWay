public class Shuixian{
    public static void main(String[] args){
        int i;
        int j;
        int k;
        int num=0;
        int plus=0;
        for(i=0; i<10; i++){
            for(j=0; j<10; j++){
                for(k=1;k<10;k++){
                    num = k*100 + j*10 + i;
                    plus= k*k*k+j*j*j+i*i*i;
                    if(num==plus){
                        System.out.println("水仙花数为"+k+"^3"+"+"+j+"^3"+"+"+i+"^3"+"="+num);
                    }
                }
            }
        }
    }
}