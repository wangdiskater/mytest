package mytest.jdk.concureent.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @ClassName UserThreadFactory
 * @Author wangDi
 * @date 2021-03-18 17:56
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePreFix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    public UserThreadFactory(String namePreFix) {
        this.namePreFix = "From UserThreadFactory's " + namePreFix + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String s = namePreFix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, s, 0, false);
        System.out.println(thread.getName());
        return thread;
    }


    public static void main(String[] args) {
        UserThreadFactory userThreadFactory = new UserThreadFactory("wangdi");
        Thread thread = userThreadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("冲TMD！");
                System.out.println(Thread.currentThread().getName());
            }
        });

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), userThreadFactory);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("冲TMD！2222");
                System.out.println(Thread.currentThread().getName());
            }
        });

    }
}
