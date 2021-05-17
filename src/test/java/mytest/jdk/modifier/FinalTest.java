package mytest.jdk.modifier;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @ClassName FinalTest
 * @Author wangDi
 * @date 2021-05-17 14:18
 */
public class FinalTest {

    /**
     * 局部变量final 只能设置一次值
     */
    @Test
    void finalTest1(){
        final int a;
        a = 100;
        System.out.println(a);
    }


}
