package mytest.jdk.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Description
 * @ClassName ClassUtil
 * @Author wangDi
 * @date 2020-10-20 10:06
 */
public class ClassUtil<T> {

    Class<T> type;

    public ClassUtil() {
        type = (Class<T>) getClass();
    }

    private  void interpreter(List<T> data) {





    }

    public static void main(String[] args) {

    }

}
