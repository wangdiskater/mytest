package mytest.jdk.collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @ClassName ListTest
 * @Author wangDi
 * @date 2021-03-17 15:44
 */
public class ListTest {
    private List<String> strings;


    @BeforeEach
    void addElement() {
        strings = new ArrayList<>();
        strings.add("aw1");
        strings.add("aw2");
        strings.add("aw3");
        strings.add("aw4");
        strings.add("aw5");
        strings.add("aw6");
    }

    @Test
    void subTest() {
        List<String> stringList = strings.subList(0, 1);
        stringList.set(0, "change my mind!");
        strings.forEach(s -> System.out.println(s));

    }


    @Test
    void toArrayList() {
        String[] strings = this.strings.toArray(new String[0]);
        System.out.println(strings);

        List<String> collect = Stream.of(strings).collect(Collectors.toList());


    }

    @Test
    void allListTest() {
        List<String> list2 = null;
        strings.addAll(list2);
    }

    @Test
    void nullTest() {

        List<NullObj> objects = new ArrayList<>();
        objects.add(new NullObj());
        objects.add(null);
        objects.add(new NullObj());
        objects.add(new NullObj());
        objects.forEach(System.out::println);

    }
    static class NullObj{

    }

}
