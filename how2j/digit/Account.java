package digit;

import java.util.Scanner;
import exception.OverdraftException;

public class Account {
    double balance;

    public void setBlance(double bla){
        this.balance = bla;
    }
    public double getBlance(){
        return balance;
    }
    public void deposit(double dep) {
        this.balance += dep;
    }
    public void withdraw(double draw) throws OverdraftException{
        this.balance -= draw;
        if(balance < 0){
            throw new OverdraftException("余额不足警告！", balance);
        }
    }
    public static void main(String[] args){
        Account hankow = new Account();
        hankow.setBlance(1000.76);
        hankow.deposit(6722.98);
        try {
			hankow.withdraw(13542.87);
		} catch (OverdraftException e) {
			e.printStackTrace();
        }
        System.out.println("***************************");

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
        }catch (OverdraftException e){
            e.printStackTrace();
        }
        System.out.println("取款后当前余额为: " + hankow.getBlance());
        
    }
}