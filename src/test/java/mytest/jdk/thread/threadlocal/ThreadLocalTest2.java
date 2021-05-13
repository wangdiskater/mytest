package mytest.jdk.thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 线程池中是否还可以使用ThreadLocal
 * @ClassName ThreadLocalTest2
 * @Author wangDi
 * @date 2021-05-12 16:16
 */
public class ThreadLocalTest2 {
    public static void main(String[] args) {
        ThreadLocal<Integer> objectThreadLocal = new ThreadLocal<>();
        // 创建一个只有一个线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String name = Thread.currentThread().getName();
                    System.out.println("当前线程的名字：" + name);
                    Integer integer = objectThreadLocal.get();
                    if (integer == null || integer == 0) {
                        objectThreadLocal.set(10);
                    } else {
                        objectThreadLocal.set(--integer);
                    }
                    System.out.println("当前ThreadLocalMap对应的值" + integer);
                }
            });
        }
    }
}
