package mytest.jdk.thread.volatiles;

/**
 * @Description
 * @ClassName ResortSeqDemo
 * @Author wangDi
 * @date 2021-04-28 15:43
 */
public class ResortSeqDemo {

    static int a = 0;
    static boolean flag = false;

    /*
    多线程下flag=true可能先执行，还没走到a=1就被挂起。
    其它线程进入method02的判断，修改a的值=5，而不是6。
     */
    public static void method01() {
        a = 1;
        flag = true;
    }

    public static void method02() {
        if (flag) {
            a += 5;
        }
        System.out.println("*****retValue: " + a);
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                method02();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                method01();
            }
        }).start();
    }
}
