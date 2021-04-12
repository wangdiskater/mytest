package mytest.design.strategy.example3;

import mytest.design.strategy.example1.CashMoneyReturn;
import mytest.design.strategy.example1.CashNormal;
import mytest.design.strategy.example1.CashRebate;
import mytest.design.strategy.example1.CashSuper;

/**
 * 把选择权放回到服务，用switch控制
 * 简单工厂和策略模式结合
 *
 */
public class CashContext2 {
    private CashSuper cashSuper;

    public CashContext2(String type) {
        switch (type) {
            case "normal":
                cashSuper = new CashNormal();
                break;
            case "discount8":
                cashSuper = new CashRebate(0.8);
                break;
            case "100moneyReturn50":
                cashSuper = new CashMoneyReturn(100,50);
                break;
            default:
                cashSuper = new CashNormal();
        }
    }

    public double acceptCash (double money) {
        return cashSuper.acceptCash(money);
    }
}
