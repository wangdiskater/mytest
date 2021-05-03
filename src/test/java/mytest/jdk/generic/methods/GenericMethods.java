package mytest.jdk.generic.methods;

import java.time.LocalDate;

/**
 * @version 1.0
 * @ClassName GenericMethods
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/3 15:25
 **/

public class GenericMethods {

    public static void main(String[] args) {

        printDate("123456");
        printDate(123456);
        printDate(LocalDate.now());


    }

    private static <T> void printDate(T s) {
        System.out.println(s);
    }

}
