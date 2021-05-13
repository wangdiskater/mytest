package mytest.jdk.thread.atoms;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Description
 * @ClassName AtomArrayType
 * @Author wangDi
 * @date 2021-05-13 11:05
 */
public class AtomArrayType {
    public static void main(String[] args) {

        int[] arr = new int[10];


        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);



    }
}
