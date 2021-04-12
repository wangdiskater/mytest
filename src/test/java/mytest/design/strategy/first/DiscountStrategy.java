package mytest.design.strategy.first;

import java.math.BigDecimal;

public class DiscountStrategy implements IStrategy {

    private float discount;

    public DiscountStrategy(float discount) {
        this.discount = discount;
    }

    @Override
    public double caculate(int num, double price) {
        double doubleValue = BigDecimal.valueOf(num).multiply(BigDecimal.valueOf(price)).multiply(BigDecimal.valueOf(discount)).doubleValue();
        return doubleValue;
    }

}
