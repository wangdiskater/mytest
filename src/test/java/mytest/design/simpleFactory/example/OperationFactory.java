package mytest.design.simpleFactory.example;


/**
 * 简单工厂与运算类就是一个关联关系，通过一个switch去判断创建什么类型的option
 *
 */
public class OperationFactory {
    private String option;


    public static Operation createOperate(String option){
        Operation operation = null;

        switch (option) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;

        }
        return operation;
    }
}
