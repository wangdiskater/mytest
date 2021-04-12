package mytest.design.strategy.example2;

/**
 * 策略模式代替简单工厂模式,工厂需要不断的修改switch去选择那种operate
 *  感觉有点像适配器
 */
public class ConcreteContext {
    private Strategy strategy;

    public ConcreteContext(Strategy strategy) {
        this.strategy = strategy;
    }


    public void contextInterface(){
        strategy.AlgorithmInterface();
    }
}
