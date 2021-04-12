package mytest.jdk.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @ClassName ForEachTest
 * @Author wangDi
 * @date 2021-03-17 18:18
 */
public class ForEachTest {

    @Test
    void foreach() {
        List<String> objects = new ArrayList<>();
        objects.add("1");
        objects.add("2");
        Iterator<String> iterator = objects.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("2".equals(next)) {
                iterator.remove();
            }
        }
        for (String object : objects) { System.out.println(object); }
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        for (String s : list2) {
            if ("2".equals(s)) {
                list2.remove(s);
            }
        }



    }
}
