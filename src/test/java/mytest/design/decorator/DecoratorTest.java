package mytest.design.decorator;

import mytest.design.decorator.example1.ConcreteAbstractComponent;
import mytest.design.decorator.example1.imp.ConcreteDecoratorA;
import mytest.design.decorator.example1.imp.ConcreteDecoratorB;
import mytest.design.decorator.example2.PeopleDecoratorA;
import mytest.design.decorator.example2.PeopleDecoratorB;
import mytest.design.decorator.example2.SimplePeople;
import mytest.design.decorator.first.People;
import mytest.design.decorator.first.ifirst.imp.BlackCloth;
import mytest.design.decorator.first.ifirst.imp.RedHat;
import mytest.design.decorator.first.ifirst.imp.WhiteShoes;
import org.junit.jupiter.api.Test;


/*
    给人搭配不同服饰的系统。比如类似QQ，网络游戏或论坛的换装系统、给人搭配不同衣服裤子
 */
public class DecoratorTest {

    /**
     * 用了里氏替换原则 + 依赖倒置
     */
    @Test
    void test1() {

        People people = new People(new RedHat(),new BlackCloth(),new WhiteShoes());

    }

    /**
     * 装饰着模式简单模板
     * 感觉有点像状态模式？
     */
    @Test
    void test2() {
        ConcreteAbstractComponent concreteAbstractComponent = new ConcreteAbstractComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();
        concreteDecoratorA.setAbstractComponent(concreteAbstractComponent);
        concreteDecoratorB.setAbstractComponent(concreteDecoratorA);
        concreteDecoratorB.operation();
    }



    @Test
    void test3() {
        SimplePeople simplePeople = new SimplePeople();
        PeopleDecoratorA peopleDecoratorA = new PeopleDecoratorA();
        PeopleDecoratorB peopleDecoratorB = new PeopleDecoratorB();
        peopleDecoratorB.setSimplePeople(peopleDecoratorA);
        peopleDecoratorA.setSimplePeople(simplePeople);
        peopleDecoratorB.show();
    }
}
