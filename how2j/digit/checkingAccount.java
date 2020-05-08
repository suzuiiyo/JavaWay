package digit;

import java.util.Scanner;
import exception.OverdraftException;

public class checkingAccount extends Account {
    static private double protect = 5000;
    @Override
    public void withdraw(double draw) throws OverdraftException {
        this.balance -= draw;
        if(balance>0&&balance<protect)
            System.out.println("当前余额为：" + balance);
        else if(balance <0 && -balance < protect)
            System.out.println("已透支金额" + -balance +",剩余额度为: " + (balance + protect) );
        else if( -balance > protect)
            throw new OverdraftException("已超过最大透支额度" + protect, balance);
    }

    public static void main(String[] args){
        checkingAccount hankow = new checkingAccount();
        Scanner s = new Scanner(System.in);
        System.out.println("请输入初始余额：");
        double inputMoney = s.nextDouble();
        hankow.setBlance(inputMoney);
        System.out.println("当前余额为：" + hankow.getBlance() + '\n');
        System.out.println("请输入存款金额：");
        double increase = s.nextDouble();
        hankow.deposit(increase);
        System.out.println("当前余额为：" + hankow.getBlance() + '\n');
        System.out.println("请输入取款金额：");
        double outMoney = s.nextDouble();
        s.close();
        try{
            hankow.withdraw(outMoney);
        }catch(OverdraftException e){
            e.printStackTrace();
        }
    }
    
}