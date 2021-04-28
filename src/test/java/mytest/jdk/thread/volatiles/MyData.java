package mytest.jdk.thread.volatiles;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @ClassName MyData
 * @Author wangDi
 * @date 2021-04-28 15:06
 */
class MyData {
//    int number = 0;
    volatile int number=0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public void setTo60() {
        this.number = 60;
    }

    //此时number前面已经加了volatile，但是不保证原子性
    public void addPlusPlus() {
        number++;
    }

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}