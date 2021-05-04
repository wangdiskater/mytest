package mytest.jdk.proxy.customjava2;

import java.lang.reflect.Method;

/**
 * @version 1.0
 * @ClassName InvocationHandler
 * @Description 自定义InvocationHandler
 * @Author wangdi
 * @Date 2021/5/4 14:44
 **/

public interface InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
