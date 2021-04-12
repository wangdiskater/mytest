package mytest.design.decorator.example1.imp;

import mytest.design.decorator.example1.Decorator;

public class ConcreteDecoratorA extends Decorator {
    private String addedState;

    @Override
    public void operation() {
        super.operation();
        addedState = "new state";
        System.out.println("具体装饰对象A的操作");
    }
}
