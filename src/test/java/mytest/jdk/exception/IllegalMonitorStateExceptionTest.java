package mytest.jdk.exception;

/**
 * @Description
 * @ClassName IllegalMonitorStateExceptionTest
 * @Author wangDi
 * @date 2021-05-25 18:19
 */
public class IllegalMonitorStateExceptionTest extends Thread {
    public void run() {
        System.out.println("要执行跑了");
        notify();
    }
    public static void main(String[] args) throws Exception {
        IllegalMonitorStateExceptionTest s = new IllegalMonitorStateExceptionTest();
        System.out.println("开始执行了!");
        s.start();
        System.out.println("要等待了!");
        s.wait();
        System.out.println("结束了");
    }
}
