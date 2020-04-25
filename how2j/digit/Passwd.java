package digit;
import java.util.Random;

public class Passwd {

    public static void main(String[] args){
        //Random rand = new Random();
        char[] pass = new char[10];
        for(int i=0; i<pass.length; i++){
            pass[i] = (char)(rand.nextInt(126-33+1) + 33);  //密码可以是除空格外的显示字符
        }
        String str = String.valueOf(pass);
        System.out.println("原始密码:" +str);

        /*char[] gen = new char[3];
        boolean flag = true;
        for (int i = 0; i < 1000; i++) { // 循环判断
            gen[0] = (char) (rand.nextInt(90) + 33);
            if (gen[0] == pass[0] && flag) {
                for (int j = 0; j < 1000; j++) {
                    gen[1] = (char) (rand.nextInt(90) + 33);
                    if (gen[1] == pass[1] && flag) {
                        for (int k = 0; k < 1000; k++) {
                            gen[2] = (char) (rand.nextInt(90) + 33);
                            if (gen[2] == pass[2] && flag) {
                                String str2 = String.valueOf(gen);
                                flag = false;
                                System.out.println(str + "=" + str2);
                            }
                        }
                    }
                }
            }
        }*/
        System.out.println("\n"+ "**********************************" + "\n");

        // 递归判断
        Passwd Key = new Passwd();
        Key.arr1 = pass; // 调用arr1存入初始密码pass数组
        char pass2[] = new char[10];
        Key.arr2 = pass2;
        for(int i=0; ; i++){
            Key.judgeKey(Key.judgeKey(Key.count));
            System.out.print(Key.count + " ");
            if(Key.count==10)
                break;
        }
        System.out.println(" ");
        String str3 = String.valueOf(pass2);
        System.out.println("密码位数: " + Key.count);
        System.out.println("破解密码：" + str + " = " + str3);
    }

    static Random rand = new Random();
    private char[] arr1 = new char[10];
    private char[] arr2 = new char[10];
    int count;
    //递归判断
    public int judgeKey(int a){
        if(count<10){
            a = count;                      //实参赋值给形参
            arr2[a] = (char)(rand.nextInt(126-33+1) + 33);
        //System.out.print(arr2[count] + " ");
            if(arr1[a]==arr2[a]){
                a++;
                count = a;                  //形参的值保存到实参
            }
        }
        //System.out.print(count + " ");
        return a;
    }
}