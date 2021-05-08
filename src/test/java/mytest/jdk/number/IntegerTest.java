package mytest.jdk.number;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @Description
 * @ClassName IntergeTest
 * @Author wangDi
 * @date 2021-03-15 18:11
 */
public class IntegerTest {

    /**
     * 所有整型包装类对象之间值的比较，全部使用equals方法比较。
     * 说明：对于Integer var=?在-128至127范围内的赋值，Integer对象是在IntegerCache.cache产生，会复用已有对象，这个区间内的Integer值可以直接使用==进行判断，
     * 但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象，这是一个大坑，推荐使用equals方法进行判断。
     *
     */
    @Test
    void equalTest() {
        Integer i1 = 127;
        Integer i2 = 128;
        Integer i3 = 127;
        Integer i4 = 128;

        System.out.println("i1 = i3, result = " + (i1 == i3));
        System.out.println("i2 = i4, result = " + (i2 == i4));
        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.2)).doubleValue());
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")).doubleValue());
    }


    @Test
    void addTest() {
//        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.2)).floatValue());
//        System.out.println(new BigDecimal(0.1d).add(new BigDecimal(0.2d)).doubleValue());
//        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")).floatValue());

        BigDecimal add = new BigDecimal(0.1d).add(new BigDecimal(0.2d));
        System.out.println(add.doubleValue());
        System.out.println(add.floatValue());
        System.out.println(add.toString());

    }

    @Test
    void maxInteger(){
        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);

        //2^31 = 2,147,483,648
        int i = Integer.MAX_VALUE - 8;
        System.out.println(i);


        int i1 = Integer.MAX_VALUE - i;
        System.out.println(i1);

    }

}
