package mytest.design.proxy.first;


public class PeopleA extends ProxyPeople{
    protected ProxyPeople goal;

    public PeopleA(ProxyPeople goal) {
        this.goal = goal;
    }

    public void kill() {

        System.out.println("我要杀了你: 小" + goal.getName());

    }
}
