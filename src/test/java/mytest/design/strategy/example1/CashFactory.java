package mytest.design.strategy.example1;

public class CashFactory {
    public static CashSuper getCashSuper(String option) {
        CashSuper cashSuper = null;
        switch (option) {
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

        return cashSuper;
    }
}
