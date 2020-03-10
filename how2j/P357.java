public class P357{
    public static void main(String[] args){
        for(int i=0; i<100; i++){
            if(i%3==0||i%5==0||i%7==0)
                continue;
            System.out.println(i);
        }
    }
} 