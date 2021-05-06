package mytest.jdk.thread.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @ClassName CountDownLatchTest
 * @Author wangDi
 * @date 2021-04-29 17:45
 */

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        contdownLatch();
    }

    /**
     * 不需要知道谁做了什么，只需要知道所有人都做完了
     */
    private static void contdownLatch() throws InterruptedException {
        int count = 10;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            int finalI = i;
            new Thread(new CustomRunnable(countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.println("所有人都干完咯 ，走咯");
    }

    static class CustomRunnable implements Runnable {
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
}
