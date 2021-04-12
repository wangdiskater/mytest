package mytest.consultation;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InquiryTest {

    @Test
    void test11() {
        double test = 19.33d;
        double afterValue = test * 100;
        int intValue= (int) afterValue;

        System.out.println(intValue);
    }

    @Test
    void test2() {
        double serviceExpense = 58;
        int serviceDuration = 15;

        double unitDuration = Math.ceil(serviceDuration / 3);
        double unitPrice = serviceExpense * (unitDuration / serviceDuration);
        unitPrice = BigDecimal.valueOf(unitPrice).setScale(2, RoundingMode.HALF_EVEN).doubleValue();

        double duration2 = 2 * unitDuration;
        double price2 = serviceExpense * (duration2 / serviceDuration);
        price2 = BigDecimal.valueOf(price2).setScale(2, RoundingMode.HALF_EVEN).doubleValue();

        ArrayList<Double> list = new ArrayList();

        list.add(unitPrice);
        list.add(price2);
        list.add(serviceExpense);

        list.forEach(value->{
//            1932.9999999999998
//            3867.0
//            5800.0
//            System.out.println(value * 100);
        });

        int totalFee = 1933;
        List<Double> collect = list.stream().filter(value -> value * 100 == totalFee).collect(Collectors.toList());
        List<Double> collect2 = list.stream().filter(value -> BigDecimal.valueOf(value).multiply(BigDecimal.valueOf(100)).intValue() == totalFee).collect(Collectors.toList());

        if (collect.isEmpty()) {
            System.out.println("error");
        }

        if (collect2.isEmpty()) {
            System.out.println("error");
        }

    }

    /**
     * 寻找问题的原因
     *
     *  19.33
     *
     */
    @Test
    void  test3 () {
        double d1 = 10.53;
        double d2 = 20.4;
        double d3 = 19.33;

        System.out.println(d1 * 100);
        System.out.println(d2 * 100);
        System.out.println(d3 * 100);

        // 除法没有问题
        double d4 = 1933;
        System.out.println(d4 / 100);

        //使用包装类型尝试 -- 包装类型也是精度有问题
        Double dd1 = 10.53;
        Double dd2 = 20.4;
        Double dd3 = 19.33;

        System.out.println(dd1 * 100);
        System.out.println(dd2 * 100);
        System.out.println(dd3 * 100);

    }


}
