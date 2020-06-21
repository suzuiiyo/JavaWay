package multithreading;

import collection.Stack;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLockStack<T> implements Stack<T>{
    LinkedList<T> list = new LinkedList<T>();
    Lock lock = new ReentrantLock();

    public void push(T t){
        try{
            lock.lock();
            list.add(t);
        }finally{
            lock.unlock();
        }
    }

    public T pull(){
        try{
            lock.lock();
            return list.removeLast();
        }finally{
            lock.unlock();
        }
    }

    public T peek(){
        try{
            lock.lock();
            return list.peek();
        }finally{
            lock.unlock();
        }
    }
}