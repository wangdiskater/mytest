package mytest.jdk.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @Description 所以是一样的，被垃圾回收后，引用会 存到引用队列中
 * @ClassName PhantomReferenceTest
 * @Author wangDi
 * @date 2021-05-17 17:30
 */
public class PhantomReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);
        System.out.println(queue);
        System.out.println(pr.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(pr.get());
        System.out.println(queue);


    }
}
