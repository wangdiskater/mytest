package mytest.design.simpleFactory.first.imp;

import mytest.design.simpleFactory.first.ISFOption;

import java.math.BigDecimal;

public class AddOptionImpl implements ISFOption {
    @Override
    public double option(double a, double b) {
        return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)).doubleValue();
    }
}
