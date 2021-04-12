package mytest.jdk.concureent.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @Description 串行执行
 * @ClassName CompletableFutureTest2
 * @Author wangDi
 * @date 2021-02-22 18:05
 */
public class CompletableFutureTest2 {
    /**
     * 例如，定义两个CompletableFuture，第一个CompletableFuture根据证券名称查询证券代码，
     * 第二个CompletableFuture根据证券代码查询证券价格，这两个CompletableFuture实现串行操作如下：
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 第一个任务:
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油");
        });
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice(code);
        });
        // cfFetch成功后打印结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }

    static String queryCode(String name) {
        String code = "601857";
        System.out.println("name = "+ name + ";find code is  " + code);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return code;
    }

    static Double fetchPrice(String code) {
        double price = 5 + Math.random() * 20;
        System.out.println("code = "+ code + ";find price is  " + price);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return price;
    }
}
