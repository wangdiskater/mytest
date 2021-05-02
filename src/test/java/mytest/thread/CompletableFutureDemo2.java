package mytest.thread;

import org.checkerframework.checker.units.qual.C;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;

/**
 * @version 1.0
 * @ClassName CompletableFutureDemo2
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/2 13:29
 **/

public class CompletableFutureDemo2 {
    public static void main(String[] args) {
        CompletableFuture<String> responseFuture = CompletableFuture.supplyAsync(() -> asyncCode());
        CompletableFuture<String> oneSecondTimeout = failAfter(Duration.ofSeconds(1));
        responseFuture
                .acceptEither(oneSecondTimeout, a -> send(a))
                .exceptionally(throwable -> {
                    System.out.println("异常:" + throwable);
                    return null;
                });
    }

    private static void send(String str) {
        System.out.println("send a message:" + str);
    }

    private static <T> CompletableFuture<T> failAfter(Duration duration) {
        CompletableFuture<T> promise = new CompletableFuture<>();
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final TimeoutException ex = new TimeoutException("Timeout after " + duration);
        promise.completeExceptionally(ex);
        return promise;
    }

    private static String asyncCode() {
        try {
            System.out.println("asyncCode");
//            Thread.sleep(3000);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
