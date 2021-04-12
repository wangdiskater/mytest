package mytest.design.simpleFactory.example;

public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return numberA + numberB;
    }
}
