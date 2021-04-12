package mytest.design.simpleFactory.example;

public class OperationSub extends Operation {
    @Override
    public double getResult() {
        return numberA - numberB;
    }
}
