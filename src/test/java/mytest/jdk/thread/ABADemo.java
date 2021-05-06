package mytest.jdk.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description
 * @ClassName ABADemo
 * @Author wangDi
 * @date 2021-04-28 15:54
 */
public class ABADemo {
    static AtomicInteger atomicInteger = new AtomicInteger(100);
    public static void main(String[] args) {
        System.out.println("======ABA问题的产生======");
        new Thread(() -> {
            atomicInteger.compareAndSet(100, 101);
            atomicInteger.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            System.out.println(atomicInteger.compareAndSet(100, 2021) + "\t" + atomicInteger.get());
        }, "t2").start();
    }
}
