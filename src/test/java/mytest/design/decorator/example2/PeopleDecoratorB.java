package mytest.design.decorator.example2;

public class PeopleDecoratorB extends PeopleDecorator {

    @Override
    public void show() {
        super.show();
        System.out.println("peopleDecoratorB");
    }
}
