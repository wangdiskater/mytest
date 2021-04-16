package mytest.jdk.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

/**
 * @Description
 * @ClassName MethodTest
 * @Author wangDi
 * @date 2021-04-16 14:02
 */
public class MethodTest {




    @Test
    void method1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ReflectClass reflectClass = new ReflectClass();
        Class<? extends ReflectClass> reflectClassClass = reflectClass.getClass();

        // 这样去找一个方法，确实太麻烦了，使用注解就好很多。
        Method show = reflectClassClass.getDeclaredMethod("show", int.class, String.class, long.class);

        Method[] methods = reflectClassClass.getMethods();

        for (Method method : methods) {
            String name = method.getName();
            if ("show".equals(name)) {
                Parameter[] parameters1 = method.getParameters();

                ArrayList<Object> objects = new ArrayList<>();
                objects.add(1);
                objects.add("风流少年唐伯虎");
                objects.add(10000L);

                Object[] parameters = objects.toArray();
                String invoke = (String) method.invoke(reflectClass, parameters);

                System.out.println(invoke);
            }
        }
    }
}
