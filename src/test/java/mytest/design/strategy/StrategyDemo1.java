package mytest.design.strategy;


import mytest.design.strategy.example1.*;
import mytest.design.strategy.example3.CashContext;
import mytest.design.strategy.example3.CashContext2;
import mytest.design.strategy.first.DiscountStrategy;
import mytest.design.strategy.first.NormalStrategy;
import org.junit.jupiter.api.Test;

/**
 * 一个简单的商场收银软件，营业员根据客户的购买的单价和数量向客户收费
 * 自己简单实现
 */
public class StrategyDemo1 {

    /**
     * 我自己的实现
     */
    @Test
    void calculate() {
        int total = 0;
        total += new DiscountStrategy(0.8f).caculate(5,20);
        total += new NormalStrategy().caculate(100,2);
        System.out.println("总价格： " + total);
    }


    /**
     * 书中简单工厂的实现
     *
     */

    @Test
    void calculateBySimpleFactory(){
        int total = 0;
        total += CashFactory.getCashSuper("discount8").acceptCash(100);
        total += CashFactory.getCashSuper("normal").acceptCash(200);
        total += CashFactory.getCashSuper("100moneyReturn50").acceptCash(200);

        System.out.println("总价格： " + total);



    }

    /**
     * 使用策略模式代替简单工厂
     */
    @Test
    void calculateBySimpleFactoryAndStrategy(){
        int total = 0;
        total += new CashContext(new CashNormal()).acceptCash(200);
        total += new CashContext(new CashRebate(0.8)).acceptCash(100);
        total += new CashContext(new CashMoneyReturn(100,50)).acceptCash(200);

        System.out.println("总价格： " + total);
    }

    /**
     * 简单工厂和策略结合
     * 目的：不需要用户去指定计算规则
     */
    @Test
    void calculateByStrategy(){
        int total = 0;
        total += new CashContext2("discount8").acceptCash(100);
        total += new CashContext2("normal").acceptCash(200);
        total += new CashContext2("100moneyReturn50").acceptCash(200);

        System.out.println("总价格： " + total);
    }

}
