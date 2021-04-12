package mytest.jdk.date;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import static java.time.temporal.TemporalAdjusters.*;

/**
 * @Description
 * @ClassName TemporalAdjusterTest
 * @Author wangDi
 * @date 2021-03-18 19:40
 */
public class TemporalAdjusterTest {


    /**
     * 寻找下一个周六
     */
    @Test
    void temporalAdjuster() {
        LocalDate date = LocalDate.now();
        LocalDate with = date.with(nextOrSame(DayOfWeek.SATURDAY));


    }

    /**
     * 下一个不是20号的周六
     */
    @Test
    void customTemporalAdjuster() {
        LocalDate date = LocalDate.now();
        LocalDate with = date.with(temporal -> {
            int dowValue = DayOfWeek.SATURDAY.getValue();
            int calDow = temporal.get(ChronoField.DAY_OF_WEEK);
            int dayOfWeek = temporal.get(ChronoField.DAY_OF_MONTH);

            if (calDow == dowValue && dayOfWeek != 20) {
                return temporal;
            } else {
                int daysDiff = calDow - dowValue;

                Temporal plus = temporal.plus(daysDiff >= 0 ? (long) (7 - daysDiff) : (long) (-daysDiff), ChronoUnit.DAYS);
                int plusDayOfWeek = plus.get(ChronoField.DAY_OF_MONTH);

                if (plusDayOfWeek != 20) {
                    return plus;
                } else {
                    return plus.plus(7, ChronoUnit.DAYS);
                }
            }
        });
    }
}
