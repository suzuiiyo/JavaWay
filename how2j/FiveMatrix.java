public class FiveMatrix{
    public static void main(String[] args){
        int[][] fivex = new int[5][5];
        int max = fivex[0][0];
        int a=0;
        int b=0;
        System.out.println("���ɵĶ�ά������: ");
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                fivex[i][j] = (int)(Math.random()*100);
                if(fivex[i][j]>max){
                    max = fivex[i][j];
                    a = i;
                    b = j;
                }
                System.out.print(fivex[i][j] + " ");
                if(j>3){
                    System.out.println();
                }
            }
        }
        System.out.println("�ö�ά����������Ԫ���ǣ� " + max +"\n" +"��������fivex[" + a +"]" + "[" +b +"]");
    }
}