package mytest.jdk.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description
 * @ClassName ABADemo2
 * @Author wangDi
 * @date 2021-04-28 16:03
 */
public class ABADemo2 {

    static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100, 0);

    public static void main(String[] args) {
        System.out.println("======atomicStampedReference解决ABA======");
        new Thread(() -> {
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        }, "t1").start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 成功
            System.out.println(atomicStampedReference.compareAndSet(100, 2021, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            // 失败
            System.out.println(atomicStampedReference.compareAndSet(100, 2021, 0, 1) );
            //结果
            System.out.println(atomicStampedReference.getReference());
        }, "t2").start();
    }
}
