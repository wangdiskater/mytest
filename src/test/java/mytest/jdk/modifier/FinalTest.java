package mytest.jdk.modifier;

import org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @ClassName FinalTest
 * @Author wangDi
 * @date 2021-05-17 14:18
 */
public class FinalTest {
    private final Map finalMap =  new HashMap();
    private final List finalList =  new ArrayList();

    /**
     * 局部变量final 只能设置一次值
     */
    @Test
    void finalTest1(){
        final int a;
        a = 100;
        System.out.println(a);
    }

    /**
     * 可以修改指向的内容
     */
    @Test
    void finalTest2(){
        finalMap.put("a","b");
        finalList.add("a");
    }


}
