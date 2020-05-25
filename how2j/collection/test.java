package collection;
import java.io.*;

public class test {
    int num;
    info[] kkk;
    int[] lll = new int[10];

    public static class info{
        int count;
        info(){count=0;}
    }

    public test(){                  //构造函数
        int i;
        num=0;
        kkk= new info[2];
        kkk[0] = new info();            //初始化
        kkk[0].count=1;
        kkk[1] = new info();            //初始化
        kkk[1].count=2;
    
        for(i=0; i<10; i++){
            lll[i] = i;
        }
    }

    public static void main(String[] args) {
        test p = new test();
        System.out.println(p.kkk[0].count);
        System.out.println(p.kkk[1].count);
        System.out.println(p.lll[0]);
        System.out.println(p.lll[1]);
    }
}

