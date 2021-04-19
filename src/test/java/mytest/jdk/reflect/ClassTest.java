package mytest.jdk.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description 反射创建类并赋值
 * @ClassName ClassTest
 * @Author wangDi
 * @date 2021-04-19 11:06
 */
public class ClassTest {

    @Test
    void test1() throws Exception {
        List<String> fields = List.of("id","username","birthday","sex","address");
        List fieldsValue = List.of(1,"username", LocalDateTime.now(),"男","address");

        Class<?> aClass = Class.forName("mytest.jdk.reflect.ReflectUser");

        // 获取无参构造方法
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        for (int i = 0; i < fields.size(); i++) {

            Field fieldClass = aClass.getDeclaredField(fields.get(i));
            fieldClass.setAccessible(Boolean.TRUE);
            fieldClass.set(o,fieldsValue.get(i));

        }

        System.out.println(o);

    }

    /**
     * 讨论强转是否会报错
     */
    @Test
    void test2() throws Exception {

        Class<?> aClass1 = Class.forName("mytest.jdk.reflect.ReflectUser");
        Class<ReflectUser> aClass2 = (Class<ReflectUser>) Class.forName("mytest.jdk.reflect.ReflectUser");

        boolean equals = aClass1.equals(aClass2);
        System.out.println(equals);

    }
}
