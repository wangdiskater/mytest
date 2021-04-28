package mytest.jdk.thread;

/**
 * @Description
 * @ClassName SleepDemo
 * @Author wangDi
 * @date 2021-04-26 15:54
 */
public class SleepDemo {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("今天困得一批睡一会");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 我被自己菜醒了");
            }
        }).start();
    }
}
