package mytest.jdk.modifier;

import mytest.jdk.modifier.Father;

/**
 * @Description
 * @ClassName Stranger
 * @Author wangDi
 * @date 2021-03-17 15:03
 */
public class Stranger extends Father{
    public static void main(String[] args) {
//        Father father = new Father();
//        father.show1();
//        father.show2();
        Father.show();
        Father.show1();

    }

    public void strangeShow1(){
        System.out.println(s);
        System.out.println(s1);


    }

}
