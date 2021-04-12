package mytest.jdk.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DateTest {


    /**
     * 探究plusMonths到底加多少天？
     * 每个月加的天数是不同的。反正就是下一个月的对应天数，如果没有对应天数就是当月最后一天
     * 12.30 和 12.31 加两个月都是2月29或者28
     */
    @Test
    void test() {
//        LocalDate of1 = LocalDate.of(2020, 1, 1);
        LocalDate of2 = LocalDate.of(2019, 12, 31);
        LocalDate of = LocalDate.of(2019, 12, 30);

        System.out.println(of.plusMonths(1));
        System.out.println(of.plusMonths(2));
        System.out.println(of.plusMonths(3));
        System.out.println(of.plusMonths(4));
        System.out.println(of.plusMonths(5));
        System.out.println(of.plusMonths(6));
        System.out.println(of.plusMonths(7));
        System.out.println(of.plusMonths(8));
        System.out.println(of.plusMonths(9));
        System.out.println(of.plusMonths(10));
        System.out.println(of.plusMonths(11));
        System.out.println(of.plusMonths(12));
    }

    /**
     * isBefore isAfter是否包含今天
     * 不包含
     */
    @Test
    void test2() {
        LocalDate now = LocalDate.now();

        LocalDate defaultDate = LocalDate.of(2021, 3, 30);
        System.out.println("date is after = " + now.isAfter(defaultDate));
        System.out.println("date is equal = " + now.isEqual(defaultDate));
        System.out.println("date is before = " + now.isBefore(defaultDate));
    }

    @Test
    void test3() {
        LocalDate now = LocalDate.now();
        LocalDate startTime = LocalDate.of(2021,3,30);
        LocalDate endTime = LocalDate.of(2021,4,30);


        if (now.isBefore(startTime) || now.isAfter(endTime)) {

            System.out.println("活动已结束");
        } else {
            System.out.println("活动中");

        }

    }
}
