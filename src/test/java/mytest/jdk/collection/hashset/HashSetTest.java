package mytest.jdk.collection.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @ClassName HashSetTest
 * @Author wangDi
 * @date 2021-05-07 16:43
 */
public class HashSetTest {
    public static void main(String[] args) {

        Set<HashSetBean> hashSetBeans = new HashSet<>();
        HashSetBean hashSetBean1 = new HashSetBean("hashCode可以相等");
        HashSetBean hashSetBean2 = new HashSetBean("hashCode可以相等");
        printHashCode(hashSetBean1);
        printHashCode(hashSetBean2);
        hashSetBeans.add(hashSetBean1);
        hashSetBeans.add(hashSetBean2);
        System.out.println(hashSetBeans.size());

    }

    private static void printHashCode(HashSetBean hashSetBean1) {
        int i = hashSetBean1.hashCode();
        System.out.println("hash code: " + i);
    }

}
