package digit;

import java.util.Scanner;
import exception.OverdraftException;

public class checkingAccount extends Account {
    static private double protect = 5000;
    @Override
    public void withdraw(double draw) throws OverdraftException {
        this.balance -= draw;
        if(balance>0&&balance<protect)
            System.out.println("��ǰ���Ϊ��" + balance);
        else if(balance <0 && -balance < protect)
            System.out.println("��͸֧���" + -balance +",ʣ����Ϊ: " + (balance + protect) );
        else if( -balance > protect)
            throw new OverdraftException("�ѳ������͸֧���" + protect, balance);
    }

    public static void main(String[] args){
        checkingAccount hankow = new checkingAccount();
        Scanner s = new Scanner(System.in);
        System.out.println("�������ʼ��");
        double inputMoney = s.nextDouble();
        hankow.setBlance(inputMoney);
        System.out.println("��ǰ���Ϊ��" + hankow.getBlance() + '\n');
        System.out.println("���������");
        double increase = s.nextDouble();
        hankow.deposit(increase);
        System.out.println("��ǰ���Ϊ��" + hankow.getBlance() + '\n');
        System.out.println("������ȡ���");
        double outMoney = s.nextDouble();
        s.close();
        try{
            hankow.withdraw(outMoney);
        }catch(OverdraftException e){
            e.printStackTrace();
        }
    }
    
}