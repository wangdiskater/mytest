package mytest.jdk.proxy.customjava2;

/**
 * @version 1.0
 * @ClassName ProxyTest
 * @Description 测试手动实现JDK动态代理：
 * @Author wangdi
 * @Date 2021/5/4 14:49
 **/

public class ProxyTest {


    public static void main(String[] args) {
        CustomSmsService customSmsServiceImp = new CustomSmsServiceImp();
        customSmsServiceImp.sendMsg("源方法");


        CustomSmsService proxyObj = (CustomSmsService) CustomProxyFactory.getProxy(customSmsServiceImp, new SendMsgInvocationHandler(customSmsServiceImp));

        proxyObj.sendMsg("代理对象方法");

    }
}
