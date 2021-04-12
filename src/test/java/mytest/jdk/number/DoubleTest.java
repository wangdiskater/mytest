package mytest.jdk.number;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @Description
 * @ClassName DoubleTest
 * @Author wangDi
 * @date 2020-12-22 10:16
 */
public class DoubleTest {

    public static void main(String[] args) {
        int interval = 240;
        for (int i = 0; i < 1000; i++) {
            int betweenMinutes = i;
            BigDecimal divide = null;
            try {
                divide = BigDecimal.valueOf(betweenMinutes).divide(BigDecimal.valueOf(interval), RoundingMode.UNNECESSARY);
                Double doubleValue = divide.doubleValue();
                int intValue = divide.intValue();
                if (doubleValue == intValue) {
                    System.out.print("betweenMinutes：" + i);
                    System.out.println("    doubleValue: " + doubleValue);
                }
            } catch (ArithmeticException e) {
            }
//            if (doubleValue.intValue() == doubleValue) {
//                System.out.print("betweenMinutes：" + i);
//                System.out.println("    doubleValue: " + doubleValue);
//            }



        }
    }

    /**
     * 直接除
     */
    @Test
    void test2 () {
        double interval = 240d;
//        for (int i = 0; i < 1000; i++) {
//            int betweenMinutes = i;
//
//            // 直接除保留整数部分
//            Double v = i / interval;
//            System.out.println(v);
//            if (v.intValue() == v) {
//                System.out.print("betweenMinutes：" + betweenMinutes);
//                System.out.println("    doubleValue: " + v);
//            }
//
//        }


        for (int i = 0; i < 1000; i++) {
            ImmutablePair<Boolean, Long> booleanLongImmutablePair = checkOrderOverTime(i, interval);
            if (booleanLongImmutablePair.getLeft()) {
                System.out.println(booleanLongImmutablePair.getRight());
            }

        }
    }



    private ImmutablePair<Boolean, Long> checkOrderOverTime(long betweenMinutes, Double interval) {

        if (betweenMinutes >= interval) {
//            Double doubleValue = BigDecimal.valueOf(betweenMinutes).divide(BigDecimal.valueOf(interval), 2, RoundingMode.HALF_UP).doubleValue();

            Double doubleValue = betweenMinutes / interval;
            if (doubleValue.intValue() == doubleValue) {
                return ImmutablePair.of(Boolean.TRUE, betweenMinutes);
            }
        }
        return ImmutablePair.of(Boolean.FALSE, null);

    }

}
