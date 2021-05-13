package mytest.jdk.thread.atoms;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description 基本数据类型
 * @ClassName AtomType
 * @Author wangDi
 * @date 2021-05-13 11:03
 */
public class AtomType {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicLong atomicLong = new AtomicLong();
        AtomicBoolean atomicBoolean = new AtomicBoolean();


    }
}
