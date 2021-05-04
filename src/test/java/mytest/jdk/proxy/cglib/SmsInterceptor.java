package mytest.jdk.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @version 1.0
 * @ClassName SmsInterceptor
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/3 23:21
 **/

public class SmsInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("before");
        Object result = proxy.invoke(obj, args);
//        Object result = proxy.invokeSuper(obj, args);

        System.out.println("after");
        return result;
    }
}
