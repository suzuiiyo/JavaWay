package multithreading;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import collection.Stack;

public class MyStackLock<T> implements Stack<T> {
    LinkedList<T> list = new LinkedList<>();
    Lock lock = new ReentrantLock();
    Condition con = lock.newCondition();

    public void push(T t){
        try{
            lock.lock();
            while(list.size()>=200){
                try{
                    con.await();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            con.signalAll();
            list.addLast(t);
        }finally{
            lock.unlock();
        }
    }

    public T pull(){
        T t = null;
        try{
            lock.lock();
            while(list.isEmpty()){
                try{
                    con.await();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            con.signalAll();
            t = list.removeLast();
        }finally{
            lock.unlock();
        }
        return t;
    }

    public T peek(){
        return list.getLast();
    }
}