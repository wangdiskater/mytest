package mytest.jdk.jvm.reference;

import java.lang.ref.SoftReference;

/**
 * 对于软引用关联着的对象，只有在内存不足的时候JVM才会回收该对象
 * @Description 软引用可以和一个引用队列（ReferenceQueue）联合使用，如果软引用所引用的对象被JVM回收，这个软引用就会被加入到与之关联的引用队列中。
 * @ClassName SoftReferenceTest
 * @Author wangDi
 * @date 2021-05-17 17:10
 */
public class SoftReferenceTest {

    public static void main(String[] args) {
        SoftReference<String> sr = new SoftReference<String>(new String("hello"));
        System.out.println(sr.get());
    }

}
