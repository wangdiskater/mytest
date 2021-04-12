package mytest.jdk.number;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FloatTest {
    @Test
    void floatTest1() {
        float f1 = 0.1f;
        float f2 = 0.2f;

        float f3  = f1 + f2;
        float f4 = 0.1f+0.2f;

        System.out.println(f3); //0.3
        System.out.println(f4);//0.3
    }

    @Test
    void test2() {

        float f1 = 19.33f;
        float f2 = 100f;
        int i1 = 100;

        float f3 = f1 * f2;
        float f4 = f1 * i1;

        System.out.println(f3); //19.33
        System.out.println(f4);//19.33

        double v = 19.33 * 100;
        float v1 = 19.33f * 100;


        System.out.println(v);
        System.out.println(v1);
    }


    @Test
    void test3() {
        double d1 = 0.1d;
        double d2 = 0.2d;
        double d3 = d1 + d2;
        System.out.println(d3);
    }

    @Test
    void testDouble() {
        double d1 = 19.33d;
        double d2 = 100d;
        double d3 = d1 * d2;
    }

    @Test
    void bigDicimal() {
        BigDecimal bd = new BigDecimal("100.001");
        int scale = bd.scale();  // 3
        BigInteger bigInteger = bd.unscaledValue();  // 100001
    }

    @Test
    void bigDicimal2() {
        BigDecimal bd1 = new BigDecimal("100.001");
        BigDecimal bd2 = new BigDecimal("0.9");

        BigDecimal add = bd1.add(bd2);





    }


}
