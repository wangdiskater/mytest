package mytest.jdk.generic.interfaces;

/**
 * @version 1.0
 * @ClassName PrintByTool
 * @Description 不指定类型的泛型接口使用
 * @Author wangdi
 * @Date 2021/5/3 15:22
 **/

public class PrintByTool<T> implements GenericInterface<T> {
    @Override
    public T printBirthday() {
        return null;
    }
}
