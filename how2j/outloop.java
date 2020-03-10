public class outloop {
    public static void main(String[] args){
        boolean breakout = false;
        for(int i=0; i < 10; i++){
            for(int j = 1; j<10; j++){
                System.out.println(i + ":" + j);
                if(2 == j % 3){
                    breakout = true;
                    break;
                }
            }
        if(breakout)
            break;
        } 
    }
}