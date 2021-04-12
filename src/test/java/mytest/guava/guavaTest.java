package mytest.guava;


import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class guavaTest {

    @Test
    void guava1() {
        ListMultimap<String, String> StringMultiMap = ArrayListMultimap.create();
        StringMultiMap.put("7","kakaxi");
        StringMultiMap.put("7","chunyeyin");
        StringMultiMap.put("7","佐助");
        StringMultiMap.put("7","纳鲁托");

        StringMultiMap.put("10","阿斯玛");
        StringMultiMap.put("10","猪");
        StringMultiMap.put("10","鹿");
        StringMultiMap.put("10","蝶");



        List<String> key = StringMultiMap.get("7");

    }

    @Test
    void guavaTest2() {
        HashBiMap<String, List> objectObjectHashBiMap = HashBiMap.create();
        objectObjectHashBiMap.put("第七组",List.of("卡卡西","野原琳","宇智波带土"));
        objectObjectHashBiMap.put("第三组",List.of("千手纲手","大蛇丸","自来也"));

        BiMap<List, String> inverse = objectObjectHashBiMap.inverse();
        String s = inverse.get(List.of("卡卡西", "野原琳", "宇智波带土"));

        BiMap<String, List> inverse1 = inverse.inverse();
        List list = inverse1.get(s);

    }

    @Test
    void inverFormTest() {
        ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.putAll("b", Ints.asList(2, 4, 6));
        multimap.putAll("a", Ints.asList(4, 2, 1));
        multimap.putAll("c", Ints.asList(2, 5, 3));

        //注意我们选择的实现，因为选了TreeMultimap，得到的反转结果是有序的
        TreeMultimap<Integer, String> inverse = Multimaps.invertFrom(multimap, TreeMultimap.create());
    }

    /**
     * 拆分器
     */
    @Test
    void splitter() {
        // 普通的拆分忽略最后一个,
        String s = ",a,,b,";
        String[] split = s.split(",");
        System.out.println(split.length);

        // splitter就不会有这个问题
        Iterable<String> split1 = Splitter.on(',').split(s);
        for (String s1 : split1) {

            System.out.print(s1);
            System.out.print("->");
        }
    }



}
