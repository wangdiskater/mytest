package mytest.design.simpleFactory.first.imp;

import mytest.design.simpleFactory.first.ISFOption;

import java.math.BigDecimal;

public class MutiplyImpl implements ISFOption {
    @Override
    public double option(double a, double b) {
//        double doubleValue1 = new BigDecimal(a).multiply(new BigDecimal(b)).doubleValue();
        double doubleValue2 = BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b)).doubleValue();

        return doubleValue2;
    }
}
