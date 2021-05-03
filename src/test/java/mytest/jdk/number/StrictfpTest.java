package mytest.jdk.number;

/**
 * @version 1.0
 * @ClassName StrictfpTest
 * @Description 一旦使用了关键字strictfp来声明某个类、接口或者方法时，那么在这个关键字所声明的范围内所有浮点运算都是精确的，符合IEEE-754规范的。例如一个类被声明为strictfp
 * ，那么该类中所有的方法都是strictfp的。
 * @Author wangdi
 * @Date 2021/5/3 14:37
 **/

public strictfp class StrictfpTest {
//public  class StrictfpTest {

    public static void main(String[] args) {

        double v = 0.1 + 0.2;
        System.out.println(v);


    }
}
