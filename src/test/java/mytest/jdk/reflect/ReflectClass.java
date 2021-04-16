package mytest.jdk.reflect;

import org.junit.platform.commons.util.StringUtils;

/**
 * @Description
 * @ClassName ReflectClass
 * @Author wangDi
 * @date 2021-04-16 14:02
 */
public class ReflectClass {

    public String show(int id, String name, long salary){
        String s = "我是%s, 我的工号： %d, 我的价值是： %d";
        return String.format(s, name, id, salary);
    }
}
