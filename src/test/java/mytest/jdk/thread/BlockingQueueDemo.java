package mytest.jdk.thread;

/**
 * @Description 阻塞队列测试
 * @ClassName BlockingQueueDemo
 * @Author wangDi
 * @date 2021-05-07 11:19
 * 方法类型	抛出异常	返回布尔	阻塞	超时
 * 插入	|  add(E e)	|  offer(E e)	| put(E e)	| offer(E e,Time,TimeUnit)
 * 取出	|  remove()	|  poll()	    | take()	| poll(Time,TimeUnit)
 * 队首	|  element()|  peek()	   | 无	        |  无
 */
import java.util.concurrent.*;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
//        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
//        BlockingQueue<String> blockingQueue = new SynchronousQueue<String>();
//        addAndRemove(blockingQueue);
//        offerAndPoll(blockingQueue);
//        putAndTake(blockingQueue);
        outOfTime(blockingQueue);
    }

    private static void outOfTime(BlockingQueue<String> blockingQueue) throws InterruptedException {
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
    }

    private static void putAndTake(BlockingQueue<String> blockingQueue) throws InterruptedException {
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        System.out.println(blockingQueue.take());
        blockingQueue.put("d");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
    }

    /**
     *  是否可以返回boolean
     * @param blockingQueue
     */
    private static void offerAndPoll(BlockingQueue<String> blockingQueue) {
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("e"));
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    /**
     * 取出会报错
     * @param blockingQueue
     */
    private static void addAndRemove(BlockingQueue<String> blockingQueue) {
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.add("e"));
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //Exception in thread "main" java.util.NoSuchElementException
//        System.out.println(blockingQueue.remove());
    }
}
