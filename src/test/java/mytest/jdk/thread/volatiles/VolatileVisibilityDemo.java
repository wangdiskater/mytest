package mytest.jdk.thread.volatiles;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @ClassName VolatileVisibilityDemo
 * @Author wangDi
 * @date 2021-04-28 14:57
 */
public class VolatileVisibilityDemo {

    public static void main(String[] args) {
        volatileVisibility();
    }

    private static void volatileVisibility() {
        System.out.println("可见性测试");
        MyData myData = new MyData();
        //启动一个线程操作共享数据

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t come in");
                myData.setTo60();
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() +"\t update number value" + myData.number);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread A").start();
        //main线程持有共享数据的拷贝，一直为0

        while (myData.number == 0) {
//            System.out.println("死循环");
        }
        System.out.println("END");
    }
}
