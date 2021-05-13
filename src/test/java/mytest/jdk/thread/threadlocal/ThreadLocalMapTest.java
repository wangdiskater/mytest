package mytest.jdk.thread.threadlocal;

/**
 * @Description 初步使用
 * @ClassName ThreadLocalMapTest
 * @Author wangDi
 * @date 2021-05-12 16:01
 */
public class ThreadLocalMapTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
                    objectThreadLocal.set("老屁股" + Thread.currentThread().getName());
                    show(objectThreadLocal);
                }
                private void show(ThreadLocal<Object> objectThreadLocal) {
                    Object o = objectThreadLocal.get();
                    System.out.println(o);
                }
            }).start();
        }
    }
}
