package mytest.jdk.proxy.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @ClassName SendMsgInvocationHandler
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/3 22:02
 **/

public class SmsInvocationHandler  implements InvocationHandler {

    private final Object target;
    public SmsInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 功能描述
     * proxy :动态生成的代理类
     * method : 与代理类对象调用的方法相对应
     * args : 当前 method 方法的参数
     */
    @Override
    public String invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //注意idea:debug 会调用toString方法
        System.out.println(method.getName());

        System.out.println("before");
        // 原方法
        Object result = method.invoke(target, args);

        System.out.println("after");

        return (String) result;
    }

}
