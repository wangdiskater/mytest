package mytest.jdk.collection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description
 * @ClassName SortTest
 * @Author wangDi
 * @date 2020-12-21 16:24
 */
public class SortTest {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(12);
        integers.add(52);
        integers.add(22);
        integers.add(32);
        integers.add(11);
        integers.add(13);


        Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return 10-(t1-t2);
            }
        });

        System.out.println(integers);
    }
}
