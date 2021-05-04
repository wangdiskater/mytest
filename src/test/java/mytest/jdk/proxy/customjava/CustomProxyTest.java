package mytest.jdk.proxy.customjava;

import java.lang.reflect.InvocationTargetException;

/**
 * @version 1.0
 * @ClassName CustomProxyTest
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/3 22:36
 **/

public class CustomProxyTest {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {

        MyTargetImp myTargetImp = new MyTargetImp();


        MyTarget myProxy = (MyTarget) MyProxy.getProxyInstance(myTargetImp);

        myProxy.send("hello is me");


    }
}
