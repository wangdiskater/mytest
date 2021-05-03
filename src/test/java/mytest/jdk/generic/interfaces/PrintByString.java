package mytest.jdk.generic.interfaces;

/**
 * @version 1.0
 * @ClassName PrintByString
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/3 15:21
 **/

public class PrintByString implements GenericInterface<String> {
    @Override
    public String printBirthday() {
        return "1995-07-13";
    }
}
