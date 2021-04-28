package mytest.jdk.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @Description
 * @ClassName ChronUnitTest
 * @Author wangDi
 * @date 2021-04-20 17:26
 */
public class ChronUnitTest {
    /**
     * 是 param1 - param2 是正还是负
     * 前面小，后面大为正
     */
    @Test
    void test() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusYears(1);


        long between = ChronoUnit.DAYS.between(now, localDateTime);

        System.out.println(between);


    }
}
