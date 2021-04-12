package mytest.jdk.collection.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @ClassName GenericsTest
 * @Author wangDi
 * @date 2021-03-17 17:43
 */
public class GenericsTest {


    @Test
    void PECS() {
        //CS comsumer super   super只能添加Father和Father的子类，不能添加Father的父类,读取出来的东西只能存放在Object类里
        List<? super Father> objects = new ArrayList<>();
        objects.add(new Son());
        objects.add(new Girl());

        // PE  producer extend
        // List<? extends Father> list不能进行add，但是，这种形式还是很有用的，虽然不能使用add方法，但是可以在初始化的时候一个Season指定不同的类型。比如：
        List<? extends Father> fathers = getFathers();
        Father father = fathers.get(0);
        Human father1 = fathers.get(1);
    }

    private List<? extends Father> getFathers() {
        List<Father> fathers1 = new ArrayList<>();
        fathers1.add(new Father());
        fathers1.add(new Father());

        return fathers1;
    }


}
