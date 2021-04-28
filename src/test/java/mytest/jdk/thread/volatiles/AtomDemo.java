package mytest.jdk.thread.volatiles;

/**
 * @Description
 * @ClassName AtomDemo
 * @Author wangDi
 * @date 2021-04-28 15:38
 */
public class AtomDemo {

    public static void main(String[] args) {
        atomicDemo();
    }
    private static void atomicDemo() {
        System.out.println("原子性测试");
        MyData myData=new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t int type finally number value: "+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger type finally number value: "+myData.atomicInteger);
    }
}
