package mytest.jdk.thread.volatiles;

/**
 * @Description
 * @ClassName SynchronizedDemo
 * @Author wangDi
 * @date 2021-04-27 11:50
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static void method() {
    }
}