package mytest.jdk.thread.safe;

/**
 * @Description
 * @ClassName ThreadSafeTest
 * @Author wangDi
 * @date 2021-05-28 10:53
 */
public class ThreadSafeTest {


    public static void main(String[] args) {
        ThreadSafe threadSafe = new ThreadSafe();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // a先 启动不一定B就能读到
                    Thread.sleep(1);
                    threadSafe.write(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
        }, "A");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                int read = threadSafe.read();
                System.out.println("read: " + read);
            }
        }, "B");
        a.start();
        b.start();

    }
}
