package mytest.jdk.concureent.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @Description 简单尝试 获取股票价格为例
 * @ClassName CompletableFutureTest1
 * @Author wangDi
 * @date 2021-02-22 17:49
 */
public class CompletableFutureTest1 {
    public static void main(String[] args) throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureTest1::fetchPrice);
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
        System.out.println("Main线程： "+Thread.currentThread().getName()+ "   end");

    }

    static Double fetchPrice() {
        System.out.println("当前线程： "+Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
