package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger{
    public static void main(String[] args) {
        AtomicInteger atomicI = new AtomicInteger();
        System.out.println("atomicI=" + atomicI);     //初始化出来时0
        int i = atomicI.decrementAndGet();
        int j = atomicI.incrementAndGet();
        int k = atomicI.addAndGet(3);
        System.out.println("atomicI=" + atomicI);
        System.out.printf("%s %s %s", i, j, k);
    }
}