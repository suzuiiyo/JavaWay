package collection;

import charactor.Hero;

public interface Stack<T> {
    //��Ӣ�����뵽���λ��
    public void push(T h);
    //�����һ��Ӣ��ȡ����
    public T pull();
    //�鿴���һ��Ӣ��
    public T peek();

}