package mytest.design.strategy.example3;

import mytest.design.strategy.example1.CashSuper;

public class CashContext {
    private CashSuper cashSuper;

    public CashContext(CashSuper cashSuper) {
        this.cashSuper = cashSuper;
    }

    public double acceptCash (double money) {
        return cashSuper.acceptCash(money);
    }
}
