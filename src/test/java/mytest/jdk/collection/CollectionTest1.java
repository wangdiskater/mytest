package mytest.jdk.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description
 * @ClassName CollectionTest1
 * @Author wangDi
 * @date 2020-12-22 15:56
 */
public class CollectionTest1 {

    @Test
    void test1() {
        List<Integer> intValue = new ArrayList<>();
        intValue.add(1);
        intValue.add(15);
        intValue.add(16);
        intValue.add(14);
        intValue.add(2);
        intValue.add(47);
        Map<Boolean, List<Integer>> intMap = intValue.stream().collect(Collectors.partitioningBy(integer -> integer > 10));
        System.out.println(intMap);

        Map<Integer, List<Integer>> collect = intValue.stream().collect(Collectors.groupingBy(integer -> integer));
        System.out.println(collect);


    }



}
