
package collection;

public interface Stack2<T> {
    //把英雄推入到最后位置
    public void push(Character c);
    //把最后一个英雄取出来
    public Character pull();
    //查看最后一个英雄
    public Character peek();
}