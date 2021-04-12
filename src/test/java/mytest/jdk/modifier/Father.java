package mytest.jdk.modifier;

/**
 * @Description
 * @ClassName Father
 * @Author wangDi
 * @date 2021-03-17 15:03
 */
public class Father {

    public String s = "public";
    protected String s1 = "protected";
    String s2 = "default";
    private String s3 = "private";


    public static void show() {
        System.out.println("public");
    }


    protected static void show1() {
        System.out.println("protected");
    }

    static void show2() {
        System.out.println("default");
    }

    private static void show3() {
        System.out.println("private");
    }
}
