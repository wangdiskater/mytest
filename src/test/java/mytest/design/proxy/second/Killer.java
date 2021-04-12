package mytest.design.proxy.second;

import mytest.design.proxy.first.PeopleA;
import mytest.design.proxy.first.ProxyPeople;

public class Killer extends PeopleA {

    public Killer(ProxyPeople goal) {
        super(goal);
    }

    @Override
    public void kill(){
        System.out.println("我要替" + getName() + "杀了你: 小" + goal.getName());

    }

}
