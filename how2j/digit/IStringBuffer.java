package digit;

public interface IStringBuffer {
    public void append(String str); //׷���ַ���
    public void append(char c); //׷���ַ�
    public void insert(int pos, char b); //ָ��λ�ò����ַ�
    public void insert(int pos, String b); //ָ��λ�ò����ַ���
    public void delete(int start); //��λ�ÿ�ʼɾ��ʣ�µ�
    public void delete(int start, int end); //��λ�ÿ�ʼɾ������λ��-1
    public void reverse(); //��ת
    public int length();  //���س���
}