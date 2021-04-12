package mytest.design.proxy.example1;

public class ActualGiveSender implements GiveGift {
    @Override
    public void getMoney() {
        System.out.println("100刀");
    }

    @Override
    public void getDoll() {
        System.out.println("芭比娃娃");
    }

    @Override
    public void getFlower() {

        System.out.println("rose ");
    }
}
