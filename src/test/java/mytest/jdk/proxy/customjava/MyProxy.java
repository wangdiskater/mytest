package mytest.jdk.proxy.customjava;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @version 1.0
 * @ClassName MyProxy
 * @Description  想照抄jdk动态代理的源码手动实现动态代理，有点拉胯。
 * @Author wangdi
 * @Date 2021/5/3 22:35
 **/

public class MyProxy {

    public static Object getProxyInstance(Object myTarget) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> aClass = myTarget.getClass();
        Method[] methods = aClass.getMethods();

        // 接口类
        Class<?>[] interfaces = aClass.getInterfaces();
        Class<?> anInterface = interfaces[0];
        // imp类加载器
        ClassLoader classLoader = aClass.getClassLoader();

        getProxy(classLoader, anInterface);

        return myTarget;
    }
    /**
     * 功能描述 想照抄jdk动态代理的源码手动实现动态代理，有点拉胯。
     * @author wangdi
     * @date   2021/5/4 13:20
     * @param classLoader
     * @param anInterface
     * @return void
     */
    private static void getProxy(ClassLoader classLoader, Class<?> anInterface) {

        HashSet<Class<?>> types = new HashSet<>();
        Method[] methods = anInterface.getMethods();
        for (Method m : methods) {

            if (!Modifier.isStatic(m.getModifiers())) {
                addElementType(types, m.getReturnType());
                addElementTypes(types, m.getParameterTypes());
                addElementTypes(types, m.getExceptionTypes());
            }

        }


    }
    private static void addElementTypes(HashSet<Class<?>> types,
                                        Class<?> ... classes) {
        for (Class<?> aClass : classes) {
            addElementType(types,aClass);
        }
    }

    private static void addElementType(HashSet<Class<?>> types,
                                       Class<?> cls) {
        Class<?> type = getElementType(cls);
        if (!type.isPrimitive()) {
            types.add(type);
        }
    }

    private static Class<?> getElementType(Class<?> type) {
        Class<?> e = type;
        while (e.isArray()) {
            e = e.getComponentType();
        }
        return e;
    }
}
