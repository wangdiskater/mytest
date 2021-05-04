package mytest.jdk.proxy.customjava2;

import java.lang.reflect.Method;

/**
 * @version 1.0
 * @ClassName SendMsgInvocationHandler
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/4 14:46
 **/

public class SendMsgInvocationHandler implements InvocationHandler{
    private Object target;

    public SendMsgInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("custom proxy before");
        // 原方法
        Object result = method.invoke(target, args);

        System.out.println("custom proxy after");

        return (String) result;

    }
}
