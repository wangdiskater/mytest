package mytest.design.proxy;

import mytest.design.proxy.example1.ActualGiveSender;
import mytest.design.proxy.example1.ProxyGiveSender;
import mytest.design.proxy.first.PeopleA;
import mytest.design.proxy.first.PeopleB;
import mytest.design.proxy.second.Killer;
import org.junit.jupiter.api.Test;

/**
 * 代理模式学习：
 *
 * A 追杀 B
 *
 */
public class ProxyTest {


    /**
     * A 直接杀B
     */
    @Test
    void proxyTest() {


        PeopleB peopleB = new PeopleB();
        peopleB.setName("叶孤城");


        PeopleA peopleA = new PeopleA(peopleB);
        peopleA.setName("西门吹雪");
        peopleA.kill();

    }

    /**
     * 杀手代替杀人
     * 我只是用了简单继承，并不是代理模式
     */
    @Test
    void proxtText2() {
        PeopleB peopleB = new PeopleB();
        peopleB.setName("叶孤城");
        Killer killer = new Killer(peopleB);
        killer.setName("无名");
        killer.kill();

    }

    @Test
    void proxyTest3() {

        ActualGiveSender actualGiveSender = new ActualGiveSender();
        ProxyGiveSender proxyGiveSender = new ProxyGiveSender();
        proxyGiveSender.setActualGiveSender(actualGiveSender);

        proxyGiveSender.getDoll();
    }



}
