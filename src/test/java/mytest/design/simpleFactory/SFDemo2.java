package mytest.design.simpleFactory;

import mytest.design.simpleFactory.example.Operation;
import mytest.design.simpleFactory.example.OperationFactory;
import org.junit.jupiter.api.Test;

public class SFDemo2 {

    @Test
    void test2() {
        Operation operate = OperationFactory.createOperate("+");
        operate.numberA = 1;
        operate.numberB = 2;
        double result = operate.getResult();
        System.out.println(result);

    }
}
