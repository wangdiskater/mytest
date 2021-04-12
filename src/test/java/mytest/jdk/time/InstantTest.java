package mytest.jdk.time;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @Description
 * @ClassName InstantTest
 * @Author wangDi
 * @date 2021-03-18 19:27
 */
public class InstantTest {

    @Test
    void instantTest1() {
        // 简单使用
        Instant now = Instant.now(Clock.systemUTC());
        long epochSecond = now.getEpochSecond();
        System.out.println(epochSecond);
        long l = now.toEpochMilli();
        System.out.println(l);

        // from
        Instant from = Instant.from(LocalDateTime.now());
        System.out.println("instant.form = " + from);

    }
}
