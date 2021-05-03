package mytest.jdk.generic.classx;

/**
 * @version 1.0
 * @ClassName GenericClass
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/3 15:14
 **/

public class GenericClass<T> {
    private T name;

    public GenericClass(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public static void main(String[] args) {
        GenericClass<Integer> integerGenericClass = new GenericClass<Integer>(1564);
        GenericClass<String> stringGeneric = new GenericClass<>("你们在干吗");

    }
}
