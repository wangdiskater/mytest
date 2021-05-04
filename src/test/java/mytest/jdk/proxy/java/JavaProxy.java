package mytest.jdk.proxy.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @version 1.0
 * @ClassName JavaProxy
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/3 22:00
 **/

public class JavaProxy {
    public static void main(String[] args) {
        SmsServiceImp smsServiceImp = new SmsServiceImp();
        Class<? extends SmsServiceImp> aClass = smsServiceImp.getClass();
//        CustomSmsService newProxyInstance = (CustomSmsService) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(),
//                new SendMsgInvocationHandler(smsServiceImp));

        SmsService newProxyInstance = (SmsService) getProxyInstance(smsServiceImp, new SmsInvocationHandler(smsServiceImp));

        newProxyInstance.sendMsg2("炸了兄弟");
    }

    static Object getProxyInstance(Object target, InvocationHandler handler) {
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                handler);
        return proxy;

    }

}
