package mytest.jdk.thread;

import java.util.concurrent.*;

/**
 * @Description
 * @ClassName ThreadTest
 * @Author wangDi
 * @date 2021-04-26 15:09
 */
public class ThreadTest {


    /**
     * 多线程
     * 一边准备
     * 一边上班
     * 一边找房子
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread thread = new Thread(() -> System.out.println("我在准备呢。。。。"));
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我在上班呢");
            }
        }).start();

        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute();
        Future<String> submit = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("我在找房子呢");
                return "我在找房子呢";
            }
        });
        thread.start();


    }
}
