package mytest.design.strategy.first;

import java.math.BigDecimal;

public class NormalStrategy implements IStrategy {
    @Override
    public double caculate(int num, double price) {
        double doubleValue = BigDecimal.valueOf(num).multiply(BigDecimal.valueOf(price)).doubleValue();
        return doubleValue;
    }
}
