package digit;

import exception.IndexIsNagetiveException;
import exception.IndexOutOfRangeException;

public interface IStringBuffer {
    public void append(String str); //追加字符串
    public void append(char c); //追加字符
    public void insert(int pos, char b); //指定位置插入字符
    public void insert(int pos, String b) throws IndexIsNagetiveException, IndexOutOfRangeException, NullPointerException, exception.NullPointerException; //指定位置插入字符串
    public void delete(int start);  //从位置开始删除剩下的
    public void delete(int start, int end) throws IndexIsNagetiveException, IndexOutOfRangeException; //从位置开始删除结束位置-1
    public void reverse(); //反转
    public int length();  //返回长度
}