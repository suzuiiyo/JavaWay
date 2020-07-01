package gui;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGUI {
    public static void main(String[] args) {
        //������
        JFrame f = new JFrame("Dota2");

        //���������ô�С
        f.setSize(400, 300);

        //����������λ��
        Point p = getPointFromLocationFile();
        if(p!=null){
            f.setLocation(p.x, p.y);
        }else
            f.setLocation(200, 200);

        //�������е��������Ϊ���Զ�λ
        f.setLayout(null);

        //��ť���
        JButton b = new JButton("��������");

        //ͬʱ��������Ĵ�С��λ��
        b.setBounds(50, 50, 280, 30);

        //�Ѱ�ť���뵽��������
        f.add(b);

        //�رմ����ʱ��,�˳�����
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //�ô����ÿɼ�
        f.setVisible(true);

        //�������ӽ��� ����JFrameλ��
        new LastLocationThread(f).start();
    }

    static class Point{
        int x;
        int y;
    }

    public static Point getPointFromLocationFile(){
        File f = new File("d:/Studio/JavaWay/AC/DC/location.txt");
        Point p = null;
        try(DataInputStream dis = new DataInputStream(new FileInputStream(f))){
            int x = dis.readInt();
            int y = dis.readInt();
            p = new Point();
            p.x = x;
            p.y = y;
        }catch(FileNotFoundException e){
            //��һ������,������������ְ�ļ�,���Ի����FileNotFoundException
        }catch(IOException e){
            e.printStackTrace();
        }
        return p;
    }
}