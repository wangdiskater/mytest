package mytest.design.decorator.example2;

public class PeopleDecoratorA extends PeopleDecorator {

    @Override
    void show() {
        super.show();
        System.out.println("peopleDecoratorA");
    }
}
