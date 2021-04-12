package mytest.design.simpleFactory;

import mytest.design.simpleFactory.first.imp.AddOptionImpl;
import mytest.design.simpleFactory.first.imp.DivideImpl;
import mytest.design.simpleFactory.first.imp.MutiplyImpl;
import mytest.design.simpleFactory.first.imp.SubtractionImpl;
import org.junit.jupiter.api.Test;

/**
 * 自己写的
 */
public class SFDemo1 {

    @Test
    void Test(){
        double calculate = calculate(19.33, 100, "*");
        System.out.println(calculate);
    }


    /**
     * 输入两个数和运算符号得到结果
     *
     * @param a
     * @param b
     * @param options
     */
    double calculate(double a, double b, String options) {
        switch (options) {
            case "+" :
                return new AddOptionImpl().option(a, b);
            case "-" :
                return new SubtractionImpl().option(a, b);
            case "*" :
                return new MutiplyImpl().option(a, b);
            case "/" :
                return new DivideImpl().option(a, b);
            default:
                return 0;
        }
    }


}
