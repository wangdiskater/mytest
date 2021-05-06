package mytest.jdk.thread.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @ClassName CustomRunable
 * @Author wangDi
 * @date 2021-04-29 17:53
 */
public class CustomRunnable implements Runnable {
    private CountDownLatch countDownLatch;

    public CustomRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("我淦我自己的事情咯！");
        countDownLatch.countDown();
    }
}
