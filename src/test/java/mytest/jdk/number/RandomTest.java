package mytest.jdk.number;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Description
 * @ClassName RandomTest
 * @Author wangDi
 * @date 2021-03-22 16:39
 */
public class RandomTest {

    @Test
    void randomNum() {

        Random random = new Random();
        System.out.println( random.nextInt(10));

        System.out.println("random 对象 replace  math.random*10");
        double ceil = Math.ceil(Math.random() * 10);
        System.out.println(ceil);
    }
}
