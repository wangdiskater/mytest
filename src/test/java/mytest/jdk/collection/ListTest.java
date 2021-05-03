package mytest.jdk.collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    /**
     * 功能描述 通过反射可以在Integer的List中添加String
     * @author wangdi
     * @date   2021/5/3 15:06
     * @param
     * @return void
     */
    @Test
    void reflectAdd() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        //这里直接添加会报错
//        list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        //但是通过反射添加，是可以的
        add.invoke(list, "kl");
        System.out.println(list);
    }

}
