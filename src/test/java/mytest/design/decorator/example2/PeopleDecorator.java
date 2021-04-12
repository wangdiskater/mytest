package mytest.design.decorator.example2;

public abstract class PeopleDecorator extends SimplePeople{

    private SimplePeople simplePeople;

    public SimplePeople getSimplePeople() {
        return simplePeople;
    }

    public void setSimplePeople(SimplePeople simplePeople) {
        this.simplePeople = simplePeople;
    }

    @Override
    void show() {
        if (simplePeople != null) {
            simplePeople.show();
        }
    }
}
