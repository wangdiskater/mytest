package mytest.jdk.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @version 1.0
 * @ClassName CglibTest
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/3 23:17
 **/

public class CglibTest {
    public static void main(String[] args) {

        Class<CustomSmsService> customSmsServiceClass = CustomSmsService.class;

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(customSmsServiceClass.getClassLoader());
        enhancer.setSuperclass(customSmsServiceClass);
        enhancer.setCallback(new SmsInterceptor());

        CustomSmsService o = (CustomSmsService) enhancer.create();
        o.sendMsg("炸了");



    }
}
