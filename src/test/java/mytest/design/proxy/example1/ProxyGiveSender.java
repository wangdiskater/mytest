package mytest.design.proxy.example1;

public class ProxyGiveSender implements GiveGift {
    private ActualGiveSender actualGiveSender;

    public ActualGiveSender getActualGiveSender() {
        return actualGiveSender;
    }

    public void setActualGiveSender(ActualGiveSender actualGiveSender) {
        this.actualGiveSender = actualGiveSender;
    }

    @Override
    public void getMoney() {
        actualGiveSender.getMoney();
    }

    @Override
    public void getDoll() {
        actualGiveSender.getDoll();

    }

    @Override
    public void getFlower() {
        actualGiveSender.getFlower();

    }
}
