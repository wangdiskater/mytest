package mytest.design.simpleFactory.first.imp;

import mytest.design.simpleFactory.first.ISFOption;

import java.math.BigDecimal;

public class DivideImpl implements ISFOption {
    @Override
    public double option(double a, double b) {
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b)).doubleValue();
    }
}
