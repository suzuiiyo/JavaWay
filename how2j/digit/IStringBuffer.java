package digit;

import exception.IndexIsNagetiveException;
import exception.IndexOutOfRangeException;

public interface IStringBuffer {
    public void append(String str); //׷���ַ���
    public void append(char c); //׷���ַ�
    public void insert(int pos, char b); //ָ��λ�ò����ַ�
    public void insert(int pos, String b) throws IndexIsNagetiveException, IndexOutOfRangeException, NullPointerException, exception.NullPointerException; //ָ��λ�ò����ַ���
    public void delete(int start);  //��λ�ÿ�ʼɾ��ʣ�µ�
    public void delete(int start, int end) throws IndexIsNagetiveException, IndexOutOfRangeException; //��λ�ÿ�ʼɾ������λ��-1
    public void reverse(); //��ת
    public int length();  //���س���
}