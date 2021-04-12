package mytest.design.decorator.first;

import mytest.design.decorator.first.ifirst.AbstractCloth;
import mytest.design.decorator.first.ifirst.AbstractHat;
import mytest.design.decorator.first.ifirst.AbstractShoes;

public class People {
    private AbstractHat hat;
    private AbstractCloth cloth;
    private AbstractShoes shoes;

    public People(AbstractHat hat, AbstractCloth cloth, AbstractShoes shoes) {
        this.hat = hat;
        this.cloth = cloth;
        this.shoes = shoes;
    }
}
