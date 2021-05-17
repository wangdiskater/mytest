package mytest.jdk.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Description 弱引用也是用来描述非必需对象的，当JVM进行垃圾回收时，无论内存是否充足，都会回收被弱引用关联的对象。
 * 　　弱引用可以和一个引用队列（ReferenceQueue）联合使用，
 * 如果弱引用所引用的对象被JVM回收，这个弱引用就会被加入到与之关联的引用队列中。
 *
 *
 *
 * @ClassName WeakReferenceTest
 * @Author wangDi
 * @date 2021-05-17 17:21
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue<String> stringReferenceQueue = new ReferenceQueue<>();
        WeakReference<String> sr = new WeakReference<String>(new String("hello"),stringReferenceQueue);

        System.out.println(sr.get());
        System.out.println(stringReferenceQueue);
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sr.get());
        System.out.println(stringReferenceQueue);

    }
}
